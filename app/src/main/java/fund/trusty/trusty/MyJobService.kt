package fund.trusty.trusty

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log


/**
 * Created by well on 01.02.2018.
 */
class MyJobService : JobService() {

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        Log.d(TAG, "Performing long running task in scheduled job")
        // TODO(developer): add long running task here.
        return false
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        return false
    }

    companion object {

        private val TAG = "MyJobService"
    }

}