#include "Vehicle.hpp"


using namespace std;

Vehicle::Vehicle(string license){
    this->license = license;
}

string Vehicle::getLicense(){
    return this->license;
}

