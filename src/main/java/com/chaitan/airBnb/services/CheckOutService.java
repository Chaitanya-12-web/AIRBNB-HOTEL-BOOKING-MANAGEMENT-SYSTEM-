package com.chaitan.airBnb.services;

import com.chaitan.airBnb.entity.Booking;

public interface CheckOutService {

    String getCheckOutSession(Booking booking, String successUrl, String failureUrl);
}
