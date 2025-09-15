#include "VehicleFactory.hpp"
#include "Car.hpp"
#include "Bike.hpp"
using namespace std;

Vehicle* VehicleFactory::createVehicle(string type, string license){
    if(type == "Bike"){
        return new Bike(license);
    }else{
        return new Car(license);
    }
}