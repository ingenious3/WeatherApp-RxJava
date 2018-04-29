package com.example.ishant.weatherapp.forecastactivity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ishant.weatherapp.data.ForecastDay;
import com.example.ishant.weatherapp.data.ForecastResponse;
import com.example.ishant.weatherapp.databinding.ListItemBinding;
import com.example.ishant.weatherapp.utils.DataFormattingUtils;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private Context context;
    private ForecastResponse forecastResponse;
    private LayoutInflater inflater;


    public ForecastAdapter(Context context, ForecastResponse forecastResponse) {
        this.context = context;
        this.forecastResponse = forecastResponse;
        this.forecastResponse.getForecast().getForecastday().remove(0);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ForecastDay data = forecastResponse.getForecast().getForecastday().get(position);
        holder.bind(DataFormattingUtils.DataFormat(data));
    }
    @Override
    public int getItemCount() {
        return forecastResponse.getForecast().getForecastday().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemBinding binding;

        ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ForecastDay item) {
            binding.setData(item);
            binding.executePendingBindings();
        }
    }
}
