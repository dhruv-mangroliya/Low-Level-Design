#include "ParkingManager.hpp"
#include "ParkingSpot.hpp"
#include "Vehicle.hpp"
#include<iostream>
#include<string>
#include<map>

using namespace std;

ParkingManager::ParkingManager(int f, int l){
    this->floors = f;
    this->locations = l;
    lot.resize(f, vector<ParkingSpot*>(locations, nullptr));
    cout<<"Our parking will have "<<f<<" floors. Each floors have "<<l<<" spaces."<<endl;
}

ParkingSpot* ParkingManager::getBooking(Vehicle* v){
    string license = v->getLicense();
    if(bookings.find(license) == bookings.end()){
        cout<<"Not found"<<endl;
        return nullptr;
    }
    cout<<"Booking found"<<endl;
    return bookings[license];
}

ParkingSpot* ParkingManager::parkVehicle(Vehicle* v){
    string license = v->getLicense();
    if(bookings.find(license) != bookings.end()){
        cout<<"Your vehicle is already in parking space."<<endl;
        return bookings[license];
    }
    bool vacant = true;
    for(int i=0;i<this->floors&&vacant;i++){
        for(int j=0;j<this->locations;j++){
            if(lot[i][j] == nullptr){
                 ParkingSpot* p = new ParkingSpot(i, j);
                 p->parkVehicle(v);
                 bookings[license] = p;
                 lot[i][j] = p;
                 vacant = false;
                return p;
            }
        }
    }
    cout<<"Parking is full."<<endl;
    return nullptr;
}

ParkingSpot* ParkingManager::removeVehicle(Vehicle* v){
    string license = v->getLicense();
    ParkingSpot* loc = bookings[license];
    int i = loc->getFloor();
    int j = loc->getLocation();
    Vehicle* removedVehicle = loc->getVehicle();
    cout<<"Removed License: "<<removedVehicle->getLicense()<<" from "<<i<<" "<<j<<endl;
    lot[i][j] = nullptr;
    Vehicle* temp = nullptr;
    loc->setVehicle(temp);
    bookings.erase(license);
    return nullptr;
}