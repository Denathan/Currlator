package pl.denathan.currlator.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pl.denathan.currlator.R
import pl.denathan.currlator.currencies.CurrenciesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CurrenciesFragment().display(
            supportFragmentManager,
            R.id.fragmentContainer,
            FRAGMENT_CURRENCIES_TAG
        )
    }

    private fun Fragment.display(
        supportFragmentManager: FragmentManager,
        containerViewId: Int,
        fragmentTag: String
    ) {
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(containerViewId, this, fragmentTag)
            fragmentTransaction.commit()
        }
    }

    private companion object {
        const val FRAGMENT_CURRENCIES_TAG = "CURRENCIES_TAG"
    }
}
