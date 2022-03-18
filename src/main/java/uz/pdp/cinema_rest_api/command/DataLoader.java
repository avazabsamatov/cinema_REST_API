package uz.pdp.cinema_rest_api.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.cinema_rest_api.model.*;
import uz.pdp.cinema_rest_api.repository.*;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    HallRepository hallRepository;

    @Autowired
    PriceCategoryRepository priceCategoryRepository;

    @Autowired
    RowRepository rowRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    DistributorRepository distributorRepository;

    @Autowired
    SpecialistRepository specialistRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReservedHallRepository reservedHallRepository;

    @Autowired
    SessionDateRepository sessionDateRepository;

    @Autowired
    SessionTimeRepository sessionTimeRepository;

    @Autowired
    AfishaRepository afishaRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Hall> hallList = new ArrayList<>(Arrays.asList(
           new Hall("Zal1", null),
           new Hall("Zal2", null) ,
           new Hall("Zal3", null),
           new Hall("VIP_ZAL", 10.0)
        ));

        hallRepository.saveAll(hallList);

        Hall vip_zal = hallRepository.save(new Hall("VIP_ZAL", 10.0));

        List<PriceCategory> priceCategories = new ArrayList<>(Arrays.asList(
           new PriceCategory("Category1", 10.0, ""),
           new PriceCategory("Category2", 20.0, "")
        ));


        priceCategoryRepository.saveAll(priceCategories);
        List<Genre> genres = new ArrayList<>(Arrays.asList(
                new Genre("Dramma"),
                new Genre("Detective")
        ));

        genreRepository.saveAll(genres);

        List<Row> rows = new ArrayList<>(Arrays.asList(
                new Row(1, hallList.get(1)),
                new Row(2, hallList.get(1)),
                new Row(3, hallList.get(1)),
                new Row(4, hallList.get(1)),
                new Row(5, hallList.get(1)),
                new Row(6, hallList.get(1)),
                new Row(7, hallList.get(1)),
                new Row(8, hallList.get(1))
        ));

        rowRepository.saveAll(rows);

        List<Seat> seats = new ArrayList<Seat>(Arrays.asList(
           new Seat(1, rows.get(1), priceCategories.get(1)),
           new Seat(2, rows.get(1), priceCategories.get(1)),
           new Seat(3, rows.get(1), priceCategories.get(1)),
           new Seat(4, rows.get(1), priceCategories.get(1)),
           new Seat(1, rows.get(2), priceCategories.get(1)),
           new Seat(2, rows.get(2), priceCategories.get(1)),
           new Seat(3, rows.get(2), priceCategories.get(1)),
           new Seat(4, rows.get(2), priceCategories.get(1)),
           new Seat(1, rows.get(3), priceCategories.get(0)),
           new Seat(2, rows.get(3), priceCategories.get(0)),
           new Seat(3, rows.get(3), priceCategories.get(0)),
           new Seat(4, rows.get(3), priceCategories.get(0)),
           new Seat(1, rows.get(4), priceCategories.get(0)),
           new Seat(2, rows.get(4), priceCategories.get(0)),
           new Seat(3, rows.get(4), priceCategories.get(0)),
           new Seat(4, rows.get(4), priceCategories.get(0))
        ));
        seatRepository.saveAll(seats);

        Attachment attachment1 = attachmentRepository.save
        (new Attachment("spring-boot", "img.jpg", 100l));

        Attachment attachment2 = attachmentRepository.save
                (new Attachment("spring-mvc", "img.jpg", 5000l));


        Distributor distributor = distributorRepository.save(new Distributor(
                "John",
                "Hello guys",
                attachment1
        ));

        List<Genre> genres1= new ArrayList<>(Arrays.asList(
                new Genre("Detective"),
                new Genre("Treller"),
                new Genre("Melodramma")
        ));
        List<Genre> genres2 = genreRepository.saveAll(genres1);


        List<Specialist> specialistList = new ArrayList<>(Arrays.asList(
                new Specialist("John Sena",attachment1,SpecialistType.SPECIALIST_ACTOR),
                new Specialist("Morgarito",attachment2,SpecialistType.SPECIALIST_DIRECTOR),
                new Specialist("Monica",attachment1,SpecialistType.SPECIALIST_ACTOR),
                new Specialist("Bruse Lee",attachment1,SpecialistType.SPECIALIST_ACTOR)
        ));
        List<Specialist> specialists = specialistRepository.saveAll(specialistList);

        Movie movie = new Movie
                ("Batman",
                 "Hello",
                 90,
                 200,
                 "youtube.com",
                 attachment1,
                  LocalDate.now(),
                 12000.0,
                 distributor,
                 2.0,
                 specialists,
                 genres2);
        movieRepository.save(movie);

        Movie movie2 = new Movie
                ("Hulk",
                        "Hello",
                        120,
                        2000,
                        "youtube.com",
                        attachment2,
                        LocalDate.now(),
                        120000.0,
                        distributor,
                        5.0,
                        specialists,
                        genres1);
        movieRepository.save(movie2);


//        SessionDate sessionDate = sessionDateRepository.save
//                (new SessionDate(Timestamp.valueOf(LocalDateTime.now())));
//
//        SessionTime sessionTime = sessionTimeRepository.
//                save(new SessionTime(Timestamp.valueOf("12:00"), 10.0));


        Afisha afisha = afishaRepository.save(new Afisha(movie, true));
//
//        reservedHallRepository.save(
//                new ReservedHall(
//                     vip_zal,
//                        attachment1,
//                        sessionDate,
//                        sessionTime,
//                        sessionTime,
//                        afisha,
//                        "Hello"
//                )
//        );






        List<Attachment> all = attachmentRepository.findAll();

        List<Distributor> distributors = distributorRepository.findAll();

        List<Genre> genreList = genreRepository.findAll();

        List<Movie> movieList = movieRepository.findAll();

    }
}