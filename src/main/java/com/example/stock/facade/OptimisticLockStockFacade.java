package com.example.stock.facade;

import com.example.stock.service.OptimisticStockService;
import org.springframework.stereotype.Service;

@Service
public class OptimisticLockStockFacade {
    private OptimisticStockService optimisticStockService;

    public OptimisticLockStockFacade(OptimisticStockService optimisticStockService) {
        this.optimisticStockService = optimisticStockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while(true) {
            try {
                optimisticStockService.decrease(id, quantity);

                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }
        }
    }
}
