package com.termux.tasker;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.termux.R;

/**
 * Superclass for plug-in Activities. This class takes care of initializing aspects of the plug-in's UI to
 * look more integrated with the plug-in host.
 */
public abstract class AbstractPluginActivity extends AppCompatActivity {

    /**
     * Flag boolean that can only be set to true via the "Don't Save" menu item in
     * {@link #onMenuItemSelected(int, MenuItem)}.
     */
    /*
     * There is no need to save/restore this field's state.
     */
    protected boolean mIsCancelled = false;

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.twofortyfouram_locale_save_dontsave, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.twofortyfouram_locale_menu_dontsave:
                mIsCancelled = true;
                finish();
                return true;
            case R.id.twofortyfouram_locale_menu_save:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * During {@link #finish()}, subclasses can call this method to determine whether the Activity was
     * canceled.
     *
     * @return True if the Activity was canceled. False if the Activity was not canceled.
     */
    protected boolean isCanceled() {
        return mIsCancelled;
    }
}
