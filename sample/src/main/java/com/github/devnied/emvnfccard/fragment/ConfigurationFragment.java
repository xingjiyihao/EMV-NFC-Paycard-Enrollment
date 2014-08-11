package com.github.devnied.emvnfccard.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.view.View;

import com.github.devnied.emvnfccard.R;
import com.github.devnied.emvnfccard.activity.HomeActivity;
import com.github.devnied.emvnfccard.utils.CroutonUtils;

/**
 * Configuration fragment
 * 
 * @author Millau Julien
 * 
 */
public class ConfigurationFragment extends PreferenceFragment {

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.preferences);

		// click on clear button
		Preference clear = findPreference("clear_card");
		clear.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(final Preference preference) {
				((HomeActivity) getActivity()).clear();
				CroutonUtils.display(getActivity(), getString(R.string.card_deleted), true);
				return false;
			}
		});

	}

	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		view.setBackgroundColor(getResources().getColor(android.R.color.white));
		super.onViewCreated(view, savedInstanceState);
	}
}
