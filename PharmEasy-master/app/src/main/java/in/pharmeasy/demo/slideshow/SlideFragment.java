package in.pharmeasy.demo.slideshow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.pharmeasy.demo.R;
import in.pharmeasy.demo.data.model.Medicine;

public class SlideFragment extends Fragment {

    private static final String POSITION = "POSITION";
    @Bind(R.id.iv_thumb)
    ImageView mIvThumb;
    @Bind(R.id.tv_label)
    TextView mTvLabel;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_manufacturer)
    TextView mTvManufacturer;
    @Bind(R.id.tv_type)
    TextView mTvType;
    @Bind(R.id.tv_form)
    TextView mTvForm;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    private Medicine mMedicine;
    private String mImageUrl;

    private static final String[] sImages = new String[]{
            "http://previews.123rf.com/images/arogant/arogant0807/arogant080700020/3255496-close-up-of-pharmaceutical-different-color-medical-drugs-Stock-Photo.jpg",
            "https://www.lawyersandsettlements.com/images/pills.jpg",
            "http://previews.123rf.com/images/razvanphoto/razvanphoto0703/razvanphoto070300074/835858-Heap-of-different-drugs-useful-medical-background-image--Stock-Photo.jpg",
            "http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2014/1/5/1388928779268/Several-different-types-o-014.jpg",
            "http://media.therakyatpost.com/wp-content/uploads/2015/06/drugs-n-money.jpg"
    };

    public static SlideFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = getArguments().getInt(POSITION);
        mMedicine = ((SlideShowActivity) getActivity()).getMedicine(position);
        mImageUrl = sImages[position % sImages.length];
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(this).load(mImageUrl).into(mIvThumb);
        mTvLabel.setText(mMedicine.getLabel());
        mTvName.setText(mMedicine.getName());
        mTvManufacturer.setText(String.format("Manufacturer : %s", mMedicine.getManufacturer()));
        mTvForm.setText(String.format("Form : %s", mMedicine.getForm()));
        mTvType.setText(String.format("Type : %s", mMedicine.getType()));

        String price = null;
        if(mMedicine.getDiscountPerc() > 0){
            price = String.format("Price : %1$s ( Discount : %2$s%%)" , mMedicine.getMrp(), mMedicine.getDiscountPerc());
        }else{
            price = String.format("Price : %s", mMedicine.getMrp());
        }
        mTvPrice.setText(price);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}