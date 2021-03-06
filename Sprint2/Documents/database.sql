PGDMP     6    -    
            x            travelagency    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17124    travelagency    DATABASE     h   CREATE DATABASE travelagency WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
    DROP DATABASE travelagency;
                postgres    false            �            1259    17188    booking    TABLE     C  CREATE TABLE public.booking (
    bookingid numeric NOT NULL,
    userid numeric NOT NULL,
    routeid numeric NOT NULL,
    journeydate date NOT NULL,
    bookingdate date NOT NULL,
    canceldate date,
    bookingstatus character varying NOT NULL,
    vehicletype character varying NOT NULL,
    fare numeric NOT NULL
);
    DROP TABLE public.booking;
       public         heap    postgres    false            �            1259    17167    driver    TABLE     �   CREATE TABLE public.driver (
    driverid numeric NOT NULL,
    drivername character varying NOT NULL,
    address character varying NOT NULL,
    contact numeric NOT NULL,
    licenseno character varying NOT NULL,
    vehicleno character varying
);
    DROP TABLE public.driver;
       public         heap    postgres    false            �            1259    17159    places    TABLE     Z   CREATE TABLE public.places (
    placeid numeric NOT NULL,
    place character varying
);
    DROP TABLE public.places;
       public         heap    postgres    false            �            1259    17133    route    TABLE     �   CREATE TABLE public.route (
    routeid numeric NOT NULL,
    source character varying NOT NULL,
    destination character varying NOT NULL,
    distance numeric NOT NULL
);
    DROP TABLE public.route;
       public         heap    postgres    false            �            1259    17180    user    TABLE     4  CREATE TABLE public."user" (
    userid numeric NOT NULL,
    name character varying NOT NULL,
    contact numeric NOT NULL,
    email character varying NOT NULL,
    dob date NOT NULL,
    password character varying NOT NULL,
    gender character varying NOT NULL,
    address character varying NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    17141    vehicle    TABLE     �   CREATE TABLE public.vehicle (
    vehicleno character varying NOT NULL,
    vehiclename character varying NOT NULL,
    fare numeric NOT NULL,
    typeid numeric NOT NULL,
    routeid numeric
);
    DROP TABLE public.vehicle;
       public         heap    postgres    false            �            1259    17125    vehicletype    TABLE     �   CREATE TABLE public.vehicletype (
    typeid numeric NOT NULL,
    typename character varying NOT NULL,
    seatingcapacity numeric NOT NULL
);
    DROP TABLE public.vehicletype;
       public         heap    postgres    false            �          0    17188    booking 
   TABLE DATA           �   COPY public.booking (bookingid, userid, routeid, journeydate, bookingdate, canceldate, bookingstatus, vehicletype, fare) FROM stdin;
    public          postgres    false    206   �"       �          0    17167    driver 
   TABLE DATA           ^   COPY public.driver (driverid, drivername, address, contact, licenseno, vehicleno) FROM stdin;
    public          postgres    false    204   �"       �          0    17159    places 
   TABLE DATA           0   COPY public.places (placeid, place) FROM stdin;
    public          postgres    false    203   �"       �          0    17133    route 
   TABLE DATA           G   COPY public.route (routeid, source, destination, distance) FROM stdin;
    public          postgres    false    201   #       �          0    17180    user 
   TABLE DATA           ^   COPY public."user" (userid, name, contact, email, dob, password, gender, address) FROM stdin;
    public          postgres    false    205   5#       �          0    17141    vehicle 
   TABLE DATA           P   COPY public.vehicle (vehicleno, vehiclename, fare, typeid, routeid) FROM stdin;
    public          postgres    false    202   R#       �          0    17125    vehicletype 
   TABLE DATA           H   COPY public.vehicletype (typeid, typename, seatingcapacity) FROM stdin;
    public          postgres    false    200   o#       L           2606    17195    booking booking_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (bookingid);
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
       public            postgres    false    206            H           2606    17174    driver driver_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.driver
    ADD CONSTRAINT driver_pkey PRIMARY KEY (driverid);
 <   ALTER TABLE ONLY public.driver DROP CONSTRAINT driver_pkey;
       public            postgres    false    204            F           2606    17166    places places_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.places
    ADD CONSTRAINT places_pkey PRIMARY KEY (placeid);
 <   ALTER TABLE ONLY public.places DROP CONSTRAINT places_pkey;
       public            postgres    false    203            B           2606    17140    route route_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pkey PRIMARY KEY (routeid);
 :   ALTER TABLE ONLY public.route DROP CONSTRAINT route_pkey;
       public            postgres    false    201            J           2606    17187    user user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    205            D           2606    17148    vehicle vehicle_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY (vehicleno);
 >   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT vehicle_pkey;
       public            postgres    false    202            @           2606    17132    vehicletype vehicletypes_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.vehicletype
    ADD CONSTRAINT vehicletypes_pkey PRIMARY KEY (typeid);
 G   ALTER TABLE ONLY public.vehicletype DROP CONSTRAINT vehicletypes_pkey;
       public            postgres    false    200            N           2606    17154    vehicle fkey_routeid    FK CONSTRAINT     x   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT fkey_routeid FOREIGN KEY (routeid) REFERENCES public.route(routeid);
 >   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT fkey_routeid;
       public          postgres    false    202    2882    201            Q           2606    17201    booking fkey_routeid    FK CONSTRAINT     x   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT fkey_routeid FOREIGN KEY (routeid) REFERENCES public.route(routeid);
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT fkey_routeid;
       public          postgres    false    206    2882    201            M           2606    17149    vehicle fkey_typeid    FK CONSTRAINT     {   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT fkey_typeid FOREIGN KEY (typeid) REFERENCES public.vehicletype(typeid);
 =   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT fkey_typeid;
       public          postgres    false    202    200    2880            P           2606    17196    booking fkey_userid    FK CONSTRAINT     v   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT fkey_userid FOREIGN KEY (userid) REFERENCES public."user"(userid);
 =   ALTER TABLE ONLY public.booking DROP CONSTRAINT fkey_userid;
       public          postgres    false    2890    205    206            O           2606    17175    driver fkey_vehicleno    FK CONSTRAINT        ALTER TABLE ONLY public.driver
    ADD CONSTRAINT fkey_vehicleno FOREIGN KEY (vehicleno) REFERENCES public.vehicle(vehicleno);
 ?   ALTER TABLE ONLY public.driver DROP CONSTRAINT fkey_vehicleno;
       public          postgres    false    202    2884    204            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     