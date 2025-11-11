package com.basketball.referee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.basketball.referee.model.Court;
import com.basketball.referee.repository.CourtRepository;

@ExtendWith(MockitoExtension.class)
public class CourtServiceTest {
    
    @Mock
    private CourtRepository courtRepository;

    @InjectMocks
    private CourtService courtService;

    @Test
    void CourtService_findByActiveTrue_ReturnsCourt(){
        Court court1 = new Court("name1", "address1");
        Court court2 = new Court("name2", "address2");
        List<Court> expectedCourt = Arrays.asList(court1, court2);
        

        when(courtRepository.findByActiveTrue()).thenReturn(expectedCourt);

        List<Court> result = courtService.findAllActive();

        assertFalse(result.isEmpty(), "La lista no debe estar vacía");
        assertEquals(2, result.size(), "Debe retornar 2 canchas");
    }
}
