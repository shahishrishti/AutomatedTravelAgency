PGDMP     0        	            x            ata    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17047    ata    DATABASE     _   CREATE DATABASE ata WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
    DROP DATABASE ata;
                postgres    false            �            1259    17104    booking    TABLE     �  CREATE TABLE public.booking (
    "bookingId" numeric(8,0) NOT NULL,
    username character varying NOT NULL,
    "contactNo" numeric(10,0) NOT NULL,
    "noOfPassengers" numeric NOT NULL,
    "boardingPoint" character varying NOT NULL,
    "dropPoint" character varying NOT NULL,
    "journeyDate" date NOT NULL,
    "bookingDate" date NOT NULL,
    "cancelDate" date,
    fare numeric NOT NULL,
    "bookingStatus" character varying NOT NULL,
    "routeId" numeric(8,0) NOT NULL
);
    DROP TABLE public.booking;
       public         heap    postgres    false            �            1259    17056    driver    TABLE     �   CREATE TABLE public.driver (
    "driverId" numeric(8,0) NOT NULL,
    name character varying NOT NULL,
    address character varying NOT NULL,
    contact numeric(10,0) NOT NULL,
    "licenseNo" character varying NOT NULL
);
    DROP TABLE public.driver;
       public         heap    postgres    false            �            1259    17064    route    TABLE     �   CREATE TABLE public.route (
    "routeId" numeric(8,0) NOT NULL,
    source character varying NOT NULL,
    destination character varying NOT NULL,
    duration numeric NOT NULL,
    distance numeric NOT NULL
);
    DROP TABLE public.route;
       public         heap    postgres    false            �            1259    17048    vehicle    TABLE     :  CREATE TABLE public.vehicle (
    "vehicleId" numeric(8,0) NOT NULL,
    "vehicleName" character varying NOT NULL,
    "vehicleType" character varying NOT NULL,
    "vehicleNo" character varying NOT NULL,
    "seatingCapacity" numeric(3,0) NOT NULL,
    "farePerKm" numeric NOT NULL,
    "routeId" numeric(8,0)
);
    DROP TABLE public.vehicle;
       public         heap    postgres    false            �            1259    17091    vehicle_driver    TABLE     b   CREATE TABLE public.vehicle_driver (
    "vehicleId" numeric(8,0),
    "driverId" numeric(8,0)
);
 "   DROP TABLE public.vehicle_driver;
       public         heap    postgres    false            �          0    17104    booking 
   TABLE DATA           �   COPY public.booking ("bookingId", username, "contactNo", "noOfPassengers", "boardingPoint", "dropPoint", "journeyDate", "bookingDate", "cancelDate", fare, "bookingStatus", "routeId") FROM stdin;
    public          postgres    false    204          �          0    17056    driver 
   TABLE DATA           Q   COPY public.driver ("driverId", name, address, contact, "licenseNo") FROM stdin;
    public          postgres    false    201   *       �          0    17064    route 
   TABLE DATA           S   COPY public.route ("routeId", source, destination, duration, distance) FROM stdin;
    public          postgres    false    202   G       �          0    17048    vehicle 
   TABLE DATA           �   COPY public.vehicle ("vehicleId", "vehicleName", "vehicleType", "vehicleNo", "seatingCapacity", "farePerKm", "routeId") FROM stdin;
    public          postgres    false    200   d       �          0    17091    vehicle_driver 
   TABLE DATA           A   COPY public.vehicle_driver ("vehicleId", "driverId") FROM stdin;
    public          postgres    false    203   �       ;           2606    17111    booking booking_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY ("bookingId");
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
       public            postgres    false    204            7           2606    17063    driver driver_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.driver
    ADD CONSTRAINT driver_pkey PRIMARY KEY ("driverId");
 <   ALTER TABLE ONLY public.driver DROP CONSTRAINT driver_pkey;
       public            postgres    false    201            9           2606    17078    route route_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pkey PRIMARY KEY ("routeId");
 :   ALTER TABLE ONLY public.route DROP CONSTRAINT route_pkey;
       public            postgres    false    202            5           2606    17055    vehicle vehicle_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY ("vehicleId");
 >   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT vehicle_pkey;
       public            postgres    false    200            >           2606    17099    vehicle_driver fkey_driverId    FK CONSTRAINT     �   ALTER TABLE ONLY public.vehicle_driver
    ADD CONSTRAINT "fkey_driverId" FOREIGN KEY ("driverId") REFERENCES public.driver("driverId");
 H   ALTER TABLE ONLY public.vehicle_driver DROP CONSTRAINT "fkey_driverId";
       public          postgres    false    203    201    2871            ?           2606    17112    booking fkey_routeId    FK CONSTRAINT     ~   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT "fkey_routeId" FOREIGN KEY ("routeId") REFERENCES public.route("routeId");
 @   ALTER TABLE ONLY public.booking DROP CONSTRAINT "fkey_routeId";
       public          postgres    false    2873    204    202            <           2606    17079    vehicle fkey_route_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT fkey_route_id FOREIGN KEY ("routeId") REFERENCES public.route("routeId") NOT VALID;
 ?   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT fkey_route_id;
       public          postgres    false    200    202    2873            =           2606    17094    vehicle_driver fkey_vehicleId    FK CONSTRAINT     �   ALTER TABLE ONLY public.vehicle_driver
    ADD CONSTRAINT "fkey_vehicleId" FOREIGN KEY ("vehicleId") REFERENCES public.vehicle("vehicleId");
 I   ALTER TABLE ONLY public.vehicle_driver DROP CONSTRAINT "fkey_vehicleId";
       public          postgres    false    2869    200    203            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     