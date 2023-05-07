package com.project.myapplication;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if(isLocationPermissionGranted()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
        else{
            requestLocationPermission();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private static final int LOCATION_PERMISSION_CODE = 101;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Ibbagamuwa= new LatLng(7.55570711239234, 80.45553348361942);
        LatLng Ehetuwewa= new LatLng(7.9430625250001015, 80.34333942933829);
        LatLng Galgamuwa= new LatLng(8.003243212451967, 80.27913808103531);
        LatLng Dethawa= new LatLng(7.915519263102704, 80.24137258187238);
        LatLng Nikaweratiya= new LatLng(7.7467981089572655, 80.11367795050464);
        LatLng Anamaaduwa= new LatLng(7.871288925256572, 80.0120544254844);
        LatLng Madurankuli= new LatLng(7.905338841878581, 79.82296940847615);
        LatLng Puttalam= new LatLng(8.014143638762889, 79.83395573550536);
        LatLng Munneshwaram= new LatLng(7.582837668214535, 79.85867497132108);
        LatLng Mahakumbukkadawala= new LatLng(7.84684438041225, 79.90468022322082);
        LatLng Nawagaththegama= new LatLng(8.006026781985776, 80.10694024139073);
        LatLng Kurunegala= new LatLng(7.473963961941374, 80.36580562961348);
        LatLng Baminiwaththa= new LatLng(7.2274412987375465, 80.45781611848317);
        LatLng Ambanwala= new LatLng(7.211092448109839, 80.53334711680903);
        LatLng Thalawathura= new LatLng(7.205642699999098, 80.5800390066832);
        LatLng Menikhinna= new LatLng(7.312326782022688, 80.70561432346443);
        LatLng Karaliyadda= new LatLng(7.3061971903908445, 80.76603912212512);
        LatLng Mahiyangana= new LatLng(7.331028670546594, 80.9916120396342);
        LatLng Rideemaliyadda= new LatLng(7.218644200558873, 81.12138802972142);
        LatLng Dambagalla= new LatLng(6.981551124668952, 81.37868420462554);
        LatLng Ambalamoya= new LatLng(7.137200583449205, 81.71088364661145);
        LatLng Nintavur= new LatLng(7.345143986660357, 81.8458699905423);
        LatLng Dehiattakandiya= new LatLng(7.345143986660357, 81.8458699905423);
        LatLng Polonnaruwa= new LatLng(8.037175937299601, 81.07957364203901);
        LatLng Serunuwara= new LatLng(8.323991528753117, 81.29930018262334);
        LatLng Echilampatru= new LatLng(8.294096267211827, 81.35560510864806);
        LatLng Wanathawilluwa= new LatLng(8.206902958187554, 79.85798830179597);
        LatLng Thambuttegama= new LatLng(8.143014159547066, 80.2919482893063);
        LatLng Katiyawa= new LatLng(8.322420392941646, 80.40936465943106);
        LatLng Thilappane= new LatLng(8.21505824585218, 80.52060124210654);
        LatLng Gomarankadawala= new LatLng(8.671481701398957, 80.95928185385901);
        LatLng marichchkaddy= new LatLng(8.591375200747748, 79.94991296888035);



        mMap.addMarker(new MarkerOptions().position(Ibbagamuwa).title("Ibbagamuwa Agrarian centre"));
        mMap.addMarker(new MarkerOptions().position(Ehetuwewa).title("Ehetuwewa Agrarian Centre"));
        mMap.addMarker(new MarkerOptions().position(Galgamuwa).title("Agrarian Services Center GALGAMUWA"));
        mMap.addMarker(new MarkerOptions().position(Dethawa).title("Agrarian Services Center Dethawa"));
        mMap.addMarker(new MarkerOptions().position(Nikaweratiya).title("Agrarian Services Center Dethawa"));
        mMap.addMarker(new MarkerOptions().position(Anamaaduwa).title("Agrarian center Anamaduwa"));
        mMap.addMarker(new MarkerOptions().position(Madurankuli).title("Agrarian center Madurankuli"));
        mMap.addMarker(new MarkerOptions().position(Puttalam).title("Agrarian Service Centre, Puttalam"));
        mMap.addMarker(new MarkerOptions().position(Munneshwaram).title("Agrarian Service Centre, Munneshwaram"));
        mMap.addMarker(new MarkerOptions().position(Mahakumbukkadawala).title("Agrarian Service Centre, Mahakumbukkadawala"));
        mMap.addMarker(new MarkerOptions().position(Nawagaththegama).title("Agrarian Service Centre, Nawagaththegama"));
        mMap.addMarker(new MarkerOptions().position(Kurunegala).title("Agrarian Service Centre, Kurunegala"));
        mMap.addMarker(new MarkerOptions().position(Baminiwaththa).title("Agrarian Service Centre, Baminiwaththa"));
        mMap.addMarker(new MarkerOptions().position(Ambanwala).title("Agrarian Service Centre, Ambanwala"));
        mMap.addMarker(new MarkerOptions().position(Thalawathura).title("Agrarian Service Centre, Thalawathura"));
        mMap.addMarker(new MarkerOptions().position(Menikhinna).title("Agrarian Service Centre, Menikhinna"));
        mMap.addMarker(new MarkerOptions().position(Karaliyadda).title("Agrarian Service Centre, Karaliyadda"));
        mMap.addMarker(new MarkerOptions().position(Mahiyangana).title("Agrarian Service Centre, Mahiyangana"));
        mMap.addMarker(new MarkerOptions().position(Rideemaliyadda).title("Agrarian Service Centre, Rideemaliyadda"));
        mMap.addMarker(new MarkerOptions().position(Ambalamoya).title("Agrarian Service Centre, Rideemaliyadda"));
        mMap.addMarker(new MarkerOptions().position(Dambagalla).title("Agrarian Service Centre, Dambagalla"));
        mMap.addMarker(new MarkerOptions().position(Nintavur).title("Agrarian Service Centre, Nintavur"));
        mMap.addMarker(new MarkerOptions().position(Dehiattakandiya).title("Agrarian Service Centre,Dehiattakandiya"));
        mMap.addMarker(new MarkerOptions().position(Polonnaruwa).title("Agrarian Service Centre,Polonnaruwa"));
        mMap.addMarker(new MarkerOptions().position(Serunuwara).title("Agrarian Service Centre,Serunuwara"));
        mMap.addMarker(new MarkerOptions().position(Echilampatru).title("Agrarian Service Centre,Echilampatru"));
        mMap.addMarker(new MarkerOptions().position(Wanathawilluwa).title("Agrarian Service Centre,Wanathawilluwa"));
        mMap.addMarker(new MarkerOptions().position(Thambuttegama).title("Agrarian Service Centre,Thambuttegama"));
        mMap.addMarker(new MarkerOptions().position(Katiyawa).title("Agrarian Service Centre,Thambuttegama"));
        mMap.addMarker(new MarkerOptions().position(Thilappane).title("Agrarian Service Centre,Thilappane"));
        mMap.addMarker(new MarkerOptions().position(Gomarankadawala).title("Agrarian Service Centre,Gomarankadawala"));
        mMap.addMarker(new MarkerOptions().position(marichchkaddy).title("Agrarian Service Centre,marichchakaddy"));










        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ibbagamuwa, 18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
           mMap.setMyLocationEnabled(true);
       }

    }
    private boolean isLocationPermissionGranted(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
           return true;
        }
        else {
           return false;
        }
    }
    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_CODE);
    }
}