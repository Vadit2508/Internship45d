package com.internship;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    String[] nameArray = {"Iphone 14","Apple Watch Ultra","Airpods pro","Macbook Pro","Studio Display",};
    int[] imageArray = {R.drawable.iphone,R.drawable.applewatchultra,R.drawable.appleairpodspro,R.drawable.macbookpro,R.drawable.studiodisplay};

    String[] priceArray = {"129000","89000","26000","202000","189000"};
    String[] descArray = {
            "128gb,Super Retina XDR display\n" + "15.40 cm / 6.1‑inch (diagonal) all‑screen OLED display\n" + "2532x1170-pixel resolution at 460 ppi ",
            "49mm case sizes\n" + "\n" + "100 m water resistant2\n" + "\n" + "Swimproof and recreational diving to 40m2\n" + "\n" + "EN13319 certification3\n" + "\n" + "Depth gauge with water temperature sensor\n" + "\n" + "Certified IP6X dust resistant\n" + "\n" + "Tested to MIL-STD 810H4\n" + "\n" + "Customisable Action button",
            "Custom high-excursion Apple driver\n" + "Custom high dynamic range amplifier\n" + "Active Noise Cancellation\n" + "Adaptive Transparency\n" + "Vent system for pressure equalisation\n" + "Personalised Spatial Audio with dynamic head tracking1\n" + "Adaptive EQ",
            "Apple M2 Max chip\n" + "\n" + "12-core CPU with 8 performance cores and 4 efficiency cores\n" + "\n" + "38-core GPU\n" + "\n" + "16-core Neural Engine\n" + "\n" + "400GB/s memory bandwidth\n" + "\n" + "Media engine\n" + "\n" + "Hardware-accelerated H.264, HEVC, ProRes and ProRes RAW\n" + "\n" + "Video decode engine\n" + "\n" + "Two video encode engines\n" + "\n" + "Two ProRes encode and decode engines",
            "Retina 6K Display\n" + "\n" + "81.28 cm / 32-inch (diagonal) IPS LCD display with oxide TFT technology\n" + "\n" + "Resolution: 6016x3384 pixels (20.4 million pixels) at 218 pixels per inch\n" + "Aspect ratio: 16:9\n" + "XDR (Extreme Dynamic Range)\n" + "\n" + "Viewing angle: Super-wide angle with high-fidelity colour and contrast at 89º left, 89º right, 89º up, 89º down\n" + "Fully laminated; 1.65% reflectivity (typical)\n" + "Super-wide\n" + "viewing angle\n" + "Contrast ratio: 1,000,000:1\n" + "Colour: P3 wide colour gamut, 10-bit depth for 1.073 billion colours\n" + "XDR brightness: 1000 nits sustained full-screen, 1600 nits peak 1 (HDR content only)\n" + "SDR brightness: 500 nits\n" + "Technology\n" + "\n" + "2D backlighting system using 576 full array local dimming zones\n" +""


    };

    RecyclerView categoryRecyclerview;
    String[] categoryNameArray = {"iphone","watch","airpods","macbook","display"};
    int[] categoryImageArray = {R.drawable.iphone,R.drawable.applewatchultra,R.drawable.appleairpodspro,R.drawable.macbookpro,R.drawable.studiodisplay};

    ArrayList<CategoryList> arrayList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.home_recyclerview);

        //Display Data In List
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Display Data In Grid
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        ProductAdapter adapter = new ProductAdapter(getActivity(),nameArray,imageArray,priceArray,descArray);
        recyclerView.setAdapter(adapter);

        categoryRecyclerview = view.findViewById(R.id.home_recyclerview_category);
        categoryRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        categoryRecyclerview.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerview.setNestedScrollingEnabled(false);

        arrayList = new ArrayList<>();
        for(int i=0;i<categoryNameArray.length;i++){
            CategoryList  list = new CategoryList();
            list.setName(categoryNameArray[i]);
            list.setImage(categoryImageArray[i]);
            arrayList.add(list);
        }
        CategoryAdapter catAdapter = new CategoryAdapter(getActivity(),arrayList);
        categoryRecyclerview.setAdapter(catAdapter);
        return view;
    }
}