use db_my_five_minutes;

insert into tip_obavestenja (naziv) values ('Lajkovan projekat');
insert into tip_obavestenja (naziv) values ('Komentarisan projekat');
insert into tip_obavestenja (naziv) values ('Uplacen novac');
insert into tip_obavestenja (naziv) values ('Vracen novac');
insert into tip_obavestenja (naziv) values ('Odobren projekat');
insert into tip_obavestenja (naziv) values ('Zavrsen projekat uspesno');
insert into tip_obavestenja (naziv) values ('Zavrsen projekat neuspesno');

insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('mladen.potrebic@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','mladen.potrebic@gmail.com','Mladen','Potrebic',52000,'https://cdn.pixabay.com/photo/2017/12/10/14/47/piza-3010062_960_720.jpg', 'ADMINISTRATOR');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('milosh.kapor87@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','milosh.kapor87@gmail.com','Milos','Kapor',60000,'https://cdn.pixabay.com/photo/2017/11/19/23/25/bmw-2964072_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('bradicdeja@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','bradicdeja@gmail.com','Dejan','Bradic',32546,'https://cdn.pixabay.com/photo/2017/11/27/07/02/time-2980690_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('drazicb@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','drazicb@gmail.com','Branislav','Drazic',42500,'https://cdn.pixabay.com/photo/2016/05/27/18/31/chaffinch-1420407_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('dejan.mitrovic112@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','dejan.mitrovic112@gmail.com','Dejan','Mitrovic',20100,'https://cdn.pixabay.com/photo/2017/11/06/15/30/elephant-2923917_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('stefan.simikic.3@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','stefan.simikic.3@gmail.com','Stefan','Simikic',4100,'https://cdn.pixabay.com/photo/2017/11/25/12/34/hamburg-2976711_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, slika_korisnikaurl, role) values ('aleksandar.petrovic@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','aleksandar.petrovic@gmail.com','Aleksandar','Petrovic',11450,'https://cdn.pixabay.com/photo/2017/11/11/07/50/christmas-motif-2938558_960_720.jpg', 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, role) values ('novak.djokobvic@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','novak.djokobvic@gmail.com','Novak','Djkovic',54668, 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, role) values ('dusan.mandic@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','dusan.mandic@gmail.com','Dusan','Mandic',52000, 'WORKER');
insert into korisnik (username, password, email,ime,prezime,racun, role) values ('dejan.savic@gmail.com','$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi','dejan.savic@gmail.com','Dejan','Savic',24566, 'WORKER');

insert into korisnik (id,email,ime,prezime,racun) values (117,'myFiveMinutes@gmail.com','Humanitaran','Profil',24566);

insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (25, '18-06-25 22:34:09', '18-09-25 10:34:09',
 'Plume: the Omnibus',
 'The popular western webcomic, PLUME comes to an end! Get the completed series in this exclusive omnibus edition.',
 25000,
 'https://images.pexels.com/photos/701449/pexels-photo-701449.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb',
 55000,'https://www.youtube.com/watch?v=YcLTscbQeLM',1, true);
 
 insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (117, '18-09-15 22:34:09', '18-12-15 10:34:09',
 'The Sound Reactive LED Mask',
 'An electro-luminescent mask for art and music lovers, back with 8 new designs.',
 500,
 'https://images.pexels.com/photos/701336/pexels-photo-701336.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 3300,'https://www.youtube.com/watch?v=a0FXo9Pg4s4',2, true);
 
 insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (2222, '18-07-15 22:34:09', '18-10-15 10:34:09',
 'Save Gawker.com',
 'Gawker was a home for independent thought and journalism for over a decade. We want to preserve its history--and write its future.',
 1000,
 'https://images.pexels.com/photos/701026/pexels-photo-701026.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 5500,'https://www.youtube.com/watch?v=KJofQ_jiHl0',3, true);
 
  insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (123, '18-01-15 22:34:09', '18-02-10 10:34:09',
 'One travel pillow endless',
 '3-in-1 ultra versatile memory foam travel pillow that delivers maximum comfort in any situation, and packs to the size of a mango',
 300,
 'https://images.pexels.com/photos/701337/pexels-photo-701337.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 66400,'https://www.youtube.com/watch?v=uKOAFnjA4AM&pbjreload=10',4, true);
 
  insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (200, '18-01-12 22:34:09', '18-02-15 10:34:09',
 '3COIL - folding scalpel',
 'The Puna & Crane Knife are tiny in size - BIG on features. Our razor sharp knives are the perfect every day carry tool. EDC essential',
 100,
 'https://images.pexels.com/photos/702139/pexels-photo-702139.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 4500,'https://www.youtube.com/watch?v=CcZP1pY0myY',5, true);
 
  insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (14, '18-05-15 22:34:09', '18-10-15 10:34:09',
 'Critical Thinking Cards',
 '54 fallacies and biases cards for honing critical thinking skills, calling out people you’re arguing with, or spotting actual fake news',
 450,
 'https://images.pexels.com/photos/702251/pexels-photo-702251.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 6000,'https://www.youtube.com/watch?v=InILsgFuovI',6, true);
 
  insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (240, '18-02-15 22:34:09', '18-04-15 10:34:09',
 'Tank Chess',
 'Abstract, diceless, tank battle game for true thinkers and strategists. Fisher VS Patton, Zhukov VS Kasparov.',
 300,
 'https://images.pexels.com/photos/701734/pexels-photo-701734.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 7500,'https://www.youtube.com/watch?v=IASHLzrHZ-E',7, true);
 
  insert into projekat (broj_pregleda, datum_isteka, datum_objave, naziv_projekta, opis_projekta,racun,slika_url, trazena_svota, video_url, korisnik_id, odobren) values
 (306, '18-08-15 22:34:09', '18-10-15 10:34:09',
 'Universal Lens Cap ',
 'The last lens cap you ll ever need. Fits every Lens. Never falls off. Element Proof. Front/Rear Lens Cap. All with a Lifetime Warranty.',
 700,
 'https://images.pexels.com/photos/701738/pexels-photo-701738.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
 1500,'https://www.youtube.com/watch?v=5Xx6tjJUZtA',8, true);
 
 
  insert into komentar (datum, gost, tekst, projekat_id) values (
 '18-08-15 22:34:09', 'Nebojsa', 'Ovo je super projekat!', 1
 );
 
 insert into komentar (datum, gost, tekst, projekat_id) values (
 '18-10-15 22:34:09', 'Milan Petrovic', 'Ovo je super projekat!', 1
 );
 
 insert into komentar (datum, gost, tekst, projekat_id) values (
 '18-09-22 22:34:09', 'Stamenko', 'Ovo je dobro!', 1
 );
 
 insert into komentar (datum, gost, tekst, projekat_id) values (
 '18-03-05 22:34:09', 'Milica', 'Ovo je super projekat!', 1
 );
 
  insert into komentar (datum, od_korisnika_id, tekst, projekat_id) values (
 '18-02-15 22:34:09', 1, 'Ovo je super projekat!', 1
 );
 
   insert into komentar (datum, od_korisnika_id, tekst, projekat_id) values (
 '18-04-14 22:34:09', 2, 'Ovo je super projekat!', 1
 );
 
  insert into lajk (datum, gost, projekat_id) values (
 '18-05-14 22:34:09', 'Milan Petrovic', 1
 );
 
  insert into lajk (datum, gost, projekat_id) values (
 '18-04-14 22:34:09', 'Stefan', 1
 );
 
  insert into lajk (datum, gost, projekat_id) values (
 '18-06-19 22:34:09', 'Miroslav', 1
 );
 
   insert into lajk (datum, od_korisnika_id, projekat_id) values (
 '18-07-04 22:34:09', 1, 1
 );
 
    insert into lajk (datum, od_korisnika_id, projekat_id) values (
 '18-08-18 22:34:09', 2, 1
 );
 
    insert into lajk (datum, od_korisnika_id, projekat_id) values (
 '18-04-16 22:34:09', 3, 1
 );
 
    insert into lajk (datum, od_korisnika_id, projekat_id) values (
 '18-05-22 22:34:09', 4, 1
 );
 
 insert into obavestenja (datum, pregledan, tekst_obavestenja, korisnik_id, od_korisnika_id, tip_obavestenja_id) values 
('18-07-04 22:34:09', true, 'Komentarisan vam je projekat!', 1, 2, 3);

insert into obavestenja (datum, pregledan, tekst_obavestenja, korisnik_id, od_korisnika_id, tip_obavestenja_id) values 
('18-03-06 22:34:09', true, 'Lajkovan vam je projekat!', 1, 5, 2);

insert into obavestenja (datum, pregledan, tekst_obavestenja, korisnik_id, od_korisnika_id, tip_obavestenja_id) values 
('18-05-01 22:34:09', true, 'Lajkovan vam je projekat!', 1, 4, 2);

insert into obavestenja (datum, pregledan, tekst_obavestenja, korisnik_id, od_korisnika_id, tip_obavestenja_id) values 
('18-08-12 22:34:09', true, 'Komentarisan vam je projekat!', 1, 3, 2);

insert into ponuda (naslov, novcana_obaveza, tekst, projekat_id) values 
('Majica', 5, 'Majica sa nasim logom', 1);

insert into ponuda (naslov, novcana_obaveza, tekst, projekat_id) values 
('Dukserica', 10, 'Dukserica sa nasim logom', 1);

insert into ponuda (naslov, novcana_obaveza, tekst, projekat_id) values 
('Sat', 50, 'Sat sa nasim logom', 1);

insert into kategorija (ime) values (
'Design'
);

insert into kategorija (ime) values (
'Comics'
);

insert into kategorija (ime) values (
'Art'
);

insert into kategorija (ime) values (
'Food'
);

insert into kategorija (ime) values (
'Photography'
);

insert into kategorija (ime) values (
'Technology'
);

insert into kategorija (ime) values (
'Film & Video'
);

insert into projekat_kategorija (kategorija_id, projekat_id) values (1,1);
insert into projekat_kategorija (kategorija_id, projekat_id) values (2,1);
insert into projekat_kategorija (kategorija_id, projekat_id) values (1,2);
insert into projekat_kategorija (kategorija_id, projekat_id) values (2,2);
insert into projekat_kategorija (kategorija_id, projekat_id) values (3,2);
insert into projekat_kategorija (kategorija_id, projekat_id) values (3,3);

insert into uplata (suma, uplatilac_gost, projekat_id) values(
500, 'Miki', 1 );

insert into uplata (suma, uplatilac_gost, projekat_id) values(
1000, 'Stojko', 1 );

insert into uplata (suma, uplatilac_gost, projekat_id) values(
2000, 'Milenko', 1 );

insert into uplata (suma, uplatilac_gost, projekat_id) values(
3000, 'Miki Petrovic', 1 );

insert into uplata (suma, uplatilac_korisnik_id, projekat_id) values(
2000, 2, 1 );

insert into uplata (suma, uplatilac_korisnik_id, projekat_id) values(
2000, 3, 1 );

insert into uplata (suma, uplatilac_korisnik_id, projekat_id) values(
2000, 4, 1 );

insert into uplata (suma, uplatilac_korisnik_id, projekat_id) values(
2000, 5, 1 );




