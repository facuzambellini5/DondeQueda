package com.example.dondeQueda.dtos;

import java.util.List;

public class FeedResponseDto {

    private List<FeedItemWrapperDto> items;
    private boolean hasNext;

    public FeedResponseDto(List<FeedItemWrapperDto> items, boolean hasNext) {
        this.items = items;
        this.hasNext = hasNext;
    }

    public List<FeedItemWrapperDto> getItems() {
        return items;
    }

    public void setItems(List<FeedItemWrapperDto> items) {
        this.items = items;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
