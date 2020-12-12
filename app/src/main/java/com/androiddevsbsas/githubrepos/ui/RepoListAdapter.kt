package com.androiddevsbsas.githubrepos.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androiddevsbsas.githubrepos.R
import com.androiddevsbsas.githubrepos.model.GitHubRepo
import com.bumptech.glide.Glide

class RepoListAdapter(private val repoList: List<GitHubRepo>) : RecyclerView.Adapter<RepoListAdapter.RepositoryViewHolder>() {
    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var avatar: ImageView = itemView.findViewById(R.id.avatar)
        private var description: TextView = itemView.findViewById(R.id.description)
        private var name: TextView = itemView.findViewById(R.id.name)

        fun bindRepo(gitHubRepo: GitHubRepo) {
            name.text = gitHubRepo.name
            description.text = gitHubRepo.description

            Glide.with(itemView)
                    .load(gitHubRepo.owner.avatarUrl)
                    .into(avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_repo, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RepositoryViewHolder, position: Int) = viewHolder.bindRepo(repoList[position])

    override fun getItemCount() = repoList.size
}