package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.repositories.*;
import kfu.group11501.svintenok.repositories.impl.DepartureDateRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.RecallRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.TourRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.UpdateDateRepositoryImpl;
import kfu.group11501.svintenok.services.BookingService;
import kfu.group11501.svintenok.services.RecallService;
import kfu.group11501.svintenok.services.TourService;

import javax.servlet.http.Part;
import java.util.List;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;

/**
 * Author: Svintenok Kate
 * Date: 06.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TourServiceImpl implements TourService {
    final static int toursLimit = 8;
    TourRepository tourRepository = new TourRepositoryImpl();
    DepartureDateRepository departureDateRepository = new DepartureDateRepositoryImpl();
    RecallRepository recallRepository = new RecallRepositoryImpl();
    BookingService bookingService = new BookingServiceImpl();
    RecallService recallService = new RecallServiceImpl();
    UpdateDateRepository updateDateRepository = new UpdateDateRepositoryImpl();


    @Override
    public int addTour(Tour tour, String date,  Part tourPhoto) {
        int id = tourRepository.addTour(tour, date);
        if (tourPhoto.getSize() !=  0)
        downloadPhoto(tourPhoto, "tours_photo/" + id);

        return id;
    }

    @Override
    public void updateTour(Tour tour, Part tourPhoto) {
        if (tourPhoto.getSize() !=  0)
            downloadPhoto(tourPhoto, "tours_photo/" + tour.getId());

        tourRepository.updateTour(tour);
    }

    @Override
    public Tour getTourById(int id) {
        updateTours();
        Tour tour = tourRepository.getTourById(id);
        setTourAdditionalInfo(tour);
        tour.setRecallList(recallService.getRecallListByTour(id));
        return tour;
    }

    @Override
    public List<Tour> getToursList(String sorting, boolean reverse, String search, int page) {
        updateTours();
        List<Tour> tours = tourRepository.getToursList(sorting, reverse, search, page, toursLimit);
        for (Tour tour : tours){
            setTourAdditionalInfo(tour);
        }
        return tours;
    }

    private void updateTours() {
        if (!updateDateRepository.isUpdate()){
            tourRepository.updateTours();
            updateDateRepository.updateUpdateDate();
        }
    }

    private void setTourAdditionalInfo(Tour tour){
        tour.setDepartureDate(departureDateRepository.getDepartureDateById(tour.getDepartureDateId()));
        tour.setBookingCount(bookingService.getBookingCountByTour(tour.getId()));
        double rating = recallRepository.getRatingByTour(tour.getId());
        if (rating != -1)
            tour.setRating(rating);
    }

    public static int getToursLimit() {
        return toursLimit;
    }
}
