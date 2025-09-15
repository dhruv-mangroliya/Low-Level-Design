#ifndef PARKINGSPOT_H
#define PARKINGSPOT_H

#include <iostream>

using namespace std;
class Vehicle;

class ParkingSpot{
    int location;
    int floor;
    Vehicle* vehicle;

    public:
    ParkingSpot(int loc, int fl);
    int getLocation();
    int getFloor();
    Vehicle* getVehicle();
    void parkVehicle(Vehicle* v);
    Vehicle* removeVehicle(Vehicle* v);
    void setVehicle(Vehicle* v);
};

#endif