package lanou.foodpie.eat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.foodpie.R;
import lanou.foodpie.eat.delicacy.DelicacyFragment;
import lanou.foodpie.eat.home.HomeFragment;
import lanou.foodpie.eat.index.IndexFragment;
import lanou.foodpie.eat.knowledge.KnowledgeFragment;

/**
 * Created by dllo on 16/10/31.
 */
public class EatFragment extends Fragment {

    private ViewPager eat_vp;
    private TabLayout eat_tl;
private FragmentManager supportFragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_eat,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eat_vp = (ViewPager) view.findViewById(R.id.eat_vp);
        eat_tl = (TabLayout) view.findViewById(R.id.eat_tl);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new IndexFragment());
        fragments.add(new KnowledgeFragment());
        fragments.add(new DelicacyFragment());

        EatAdapter adapter =
                new EatAdapter(getActivity().getSupportFragmentManager());
        adapter.setFragments(fragments);
        eat_vp.setAdapter(adapter);
        eat_tl.setupWithViewPager(eat_vp);

    }
}
