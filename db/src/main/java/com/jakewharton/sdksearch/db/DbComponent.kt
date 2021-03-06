package com.jakewharton.sdksearch.db

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Singleton

@Singleton
@Component(modules = [
  DbModule::class
])
interface DbComponent {
  fun itemStore(): ItemStore

  @Component.Builder
  interface Builder {
    @BindsInstance fun context(context: Context): Builder
    @BindsInstance fun scheduler(scheduler: Scheduler): Builder
    @BindsInstance fun filename(filename: String?): Builder
    fun build(): DbComponent
  }

  companion object {
    fun builder(): Builder = DaggerDbComponent.builder()
  }
}
