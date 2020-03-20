package marshi.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.androidtemplate.R
import com.example.androidtemplate.databinding.AppFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AppFragment : DaggerFragment() {

    companion object {
        fun newInstance() = AppFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AppViewModel>
    lateinit var binding: AppFragmentBinding
    private val viewModel: AppViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<AppFragmentBinding>(
            inflater,
            R.layout.app_fragment,
            container,
            false
        )
        val adapter = Adapter()
        binding.recyclerView.apply {
            this.adapter = adapter
        }
        binding.button.setOnClickListener {
            adapter.isExtend = !adapter.isExtend
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.plus(1, 2)
    }

}
