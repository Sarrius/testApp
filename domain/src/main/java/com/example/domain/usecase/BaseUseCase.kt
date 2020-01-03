package com.example.domain.usecase

import com.example.data.repository.BaseRepo

open abstract class BaseUseCase(private vararg val repos: BaseRepo) {

    abstract fun refresh()

    fun clear(){
        for (repo: BaseRepo in repos){
            repo.clear()
        }
    }

    fun dispose(){
        for (repo: BaseRepo in repos){
            repo.dispose()
        }
    }
}