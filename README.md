# Beneficiary List System

The Beneficiary Management System is a Java-based application designed to manage and store information about beneficiaries. This system covers various aspects, including personal information, contact details, and designation types.

## Features
- **Beneficiary Designation**: Supports designating beneficiaries as primary, contingent, or unknown.
- **Address Management**: Handles detailed mailing addresses for each beneficiary.
- **Date Format Conversion**: Converts dates from `MMddyyyy` to `MM/dd/yyyy` format for better readability.

## Design Choices and Architecture

This section outlines the key architectural decisions

### Architecture Overview

The system uses the MVVM Architecture.

- **Model**: Defines the data structures (`Beneficiary`, `BeneficiaryAddress`) used throughout the application.
- **View**: Handles the presentation of information to the user.Within this layer, we use `RecyclerView` as a key component to efficiently display a list or grid of items.  The recycler view offers a better performance and more customization options
- **ViewModel**: Handles the loading of the asset and other business logic
- **Controller**: Acts as an intermediary between the Model and View, retrieving data and passing to the adapter.
- **Utils**: Provides utility functions (e.g., date format conversion) that support the other layers, promoting code reuse and separation of concerns.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:
- **Java SDK 11 or higher
- **An IDE (Android Studio)