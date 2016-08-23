package com.example.jayantsethi.diwithdagger.services;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NetworkStatusServiceTest {
    @Test
    public void shouldReturnTrueWhenInternetIsConnected() throws Exception {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        NetworkInfo activeNetworkInfo = mock(NetworkInfo.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(activeNetworkInfo);
        when(activeNetworkInfo.isConnected()).thenReturn(true);

        NetworkStatusService networkStatusService = new NetworkStatusService(connectivityManager);

        assertTrue(networkStatusService.isConnectedToInternet());
    }

    @Test
    public void shouldReturnFalseWhenInternetIsNotConnected() throws Exception {
        ConnectivityManager connectivityManager = mock(ConnectivityManager.class);
        NetworkInfo activeNetworkInfo = mock(NetworkInfo.class);
        when(connectivityManager.getActiveNetworkInfo()).thenReturn(activeNetworkInfo);
        when(activeNetworkInfo.isConnected()).thenReturn(false);

        NetworkStatusService networkStatusService = new NetworkStatusService(connectivityManager);

        assertFalse(networkStatusService.isConnectedToInternet());
    }
}