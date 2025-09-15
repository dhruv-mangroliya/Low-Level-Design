#include "ParkingSpot.hpp"
#include "Vehicle.hpp"

using namespace std;

ParkingSpot::ParkingSpot(int loc, int fl){
    location = loc;
    floor = fl;
}

int ParkingSpot::getFloor() {return this->floor;}
int ParkingSpot::getLocation() {return this->location;}
Vehicle* ParkingSpot::getVehicle() {return this->vehicle;}

void ParkingSpot::parkVehicle(Vehicle* v){
    vehicle = v;
    cout<<"Vehicle parked with license"<<v->getLicense()<<" at :"<<this->floor<<" , "<<this->location<<endl;
    return;
}

Vehicle* ParkingSpot::removeVehicle(Vehicle* v){
    Vehicle* rem = v;
    this->vehicle = nullptr;
    cout<<"Vehicle removed with license"<<v->getLicense()<<" from :"<<this->floor<<" , "<<this->location<<endl;
    return v;
}

void ParkingSpot::setVehicle(Vehicle* v){
    this->vehicle = v;
}
