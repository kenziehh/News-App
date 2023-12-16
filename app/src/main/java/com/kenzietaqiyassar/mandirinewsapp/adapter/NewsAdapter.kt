    package com.kenzietaqiyassar.mandirinewsapp.adapter

    import com.kenzietaqiyassar.mandirinewsapp.databinding.NewsCardBinding
    import com.kenzietaqiyassar.mandirinewsapp.model.Article

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import java.text.ParseException
    import java.text.SimpleDateFormat
    import java.util.Locale


    class NewsAdapter(private val articles: List<Article>) :
        RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = NewsCardBinding.inflate(inflater)
            return NewsViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            holder.bind(articles[position])
        }

        override fun getItemCount(): Int {
            return articles.size
        }

        class NewsViewHolder(private val binding: NewsCardBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(article: Article) {
                Glide.with(binding.articleImageView.context)
                    .load(article.urlToImage)
                    .centerCrop().into(binding.articleImageView)
                binding.articleTextView.text = article.title
                binding.articleImageView.contentDescription = article.title
                binding.articleAuthorTextView.text = article.author
                binding.articleDateTextView.text = convertDate(article.publishedAt)
            }

            fun convertDate(inputDate: String): String {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
                val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)

                try {
                    val date = inputFormat.parse(inputDate)
                    return outputFormat.format(date)
                } catch (e: ParseException) {
                    e.printStackTrace()
                    return ""
                }
            }
        }
    }