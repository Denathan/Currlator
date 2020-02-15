package pl.denathan.currlator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.fragmentContainer
import pl.denathan.currlator.currencies.CurrenciesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CurrenciesFragment().display(supportFragmentManager, R.id.fragmentContainer, FRAGMENT_CURRENCIES_TAG)
    }

    private fun Fragment.display(supportFragmentManager: FragmentManager, containerViewId: Int, fragmentTag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, this, fragmentTag)
        fragmentTransaction.commit()
    }

    private companion object {
        const val FRAGMENT_CURRENCIES_TAG = "CURRENCIES_TAG"
    }
}
