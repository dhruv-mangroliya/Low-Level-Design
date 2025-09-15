#ifndef PARKINGMANAGER_H
#define PARKINGMANAGER_H


#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Vehicle;
class ParkingSpot;

class ParkingManager{
    vector<vector<ParkingSpot*>> lot;
    unordered_map<string, ParkingSpot*> bookings;
    int floors;
    int locations;
    
    public:
    ParkingManager(int floors, int locations);
    ParkingSpot* getBooking(Vehicle* v);
    ParkingSpot* parkVehicle(Vehicle* v);
    ParkingSpot* removeVehicle(Vehicle* v);
};

#endif