package klt.mdy.contactspicker.di

import javax.inject.Qualifier

object Qualifier {
    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class Default

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class Io

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class Main

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ViewScope

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class RepoScope

}