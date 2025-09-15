#include <iostream>
#include "Vehicle.hpp"
#include "VehicleFactory.hpp"
#include "Bike.hpp"
#include "Car.hpp"

#include "ParkingManager.hpp"
#include "ParkingSpot.hpp"

using namespace std;


int main(){
    ParkingManager* manager = new ParkingManager(2,2);
    VehicleFactory* factory = new VehicleFactory();

    Vehicle* v1 = factory->createVehicle("Bike", "B001");
    Vehicle* v2 = factory->createVehicle("Bike", "B002");
    Vehicle* v3 = factory->createVehicle("Car", "C001");
    Vehicle* v4 = factory->createVehicle("Car", "C002");
    Vehicle* v5 = factory->createVehicle("Car", "C003");

    ParkingSpot* p1 = manager->parkVehicle(v1);
    ParkingSpot* p2 = manager->parkVehicle(v2);
    ParkingSpot* p3 = manager->parkVehicle(v3);
    ParkingSpot* p4 = manager->parkVehicle(v4);
    ParkingSpot* p5 = manager->parkVehicle(v5);

    manager->removeVehicle(v4);
    ParkingSpot* p6 = manager->parkVehicle(v5);
    
    Vehicle* v6 = factory->createVehicle("Bike", "B003");
    ParkingSpot* p7 = manager->parkVehicle(v6);

    manager->parkVehicle(v2);
    manager->getBooking(v4);
    manager->getBooking(v1);
    return 0;
}