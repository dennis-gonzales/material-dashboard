package pro.dennisgonzales.moderndashboard

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(20)

        itemRecyclerView.adapter = ItemAdapter(exampleList)
        itemRecyclerView.setHasFixedSize(true)

        hideTitleOnCollapsedToolbar()
    }

    private fun hideTitleOnCollapsedToolbar() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener
        { appBar: AppBarLayout, verticalOffset ->
            collapsingToolbarLayout.title = when {
                (abs(verticalOffset) - appBar.totalScrollRange != 0) -> ""
                else -> getString(R.string.app_name)
            }
        })
    }

    private fun generateDummyList(size: Int): List<Item> {

        val list = ArrayList<Item>()

        for (i in 0 until size) {
            val itemLogo = when (i % 9) {
                0 -> R.drawable.vector_boy
                1 -> R.drawable.vector_boy_2
                2 -> R.drawable.vector_girl
                3 -> R.drawable.vector_girl_2
                4 -> R.drawable.vector_man
                5 -> R.drawable.vector_man_2
                6 -> R.drawable.vector_man_3
                7 -> R.drawable.vector_man_4
                else -> R.drawable.vector_man_5
            }

            val itemBackground = when (i % 4) {
                0 -> R.drawable.item_1_background
                1 -> R.drawable.item_2_background
                2 -> R.drawable.item_3_background
                else -> R.drawable.item_4_background
            }

            val item = Item(
                itemLogo,
                itemBackground,
                "Test Name",
                "loremloremloremloremloremloremloremloremloremloremloremlorem"
            )
            list += item
        }

        return list
    }
}
