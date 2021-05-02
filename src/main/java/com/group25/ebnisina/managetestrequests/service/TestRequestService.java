package com.group25.ebnisina.managetestrequests.service;

import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.repository.LaboratorianRepository;
import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TestRequestService {

    private final TestRequestRepository testRequestRepository;
    private final ProcessRepository processRepository;
    private final LaboratorianRepository laboratorianRepository;
    private final AppointmentRepository appointmentRepository;

    public List<TestRequest> getTestRequestsOfPatient(int patient_id) {
        return testRequestRepository.getTestRequestsOfPatient(patient_id);
    }

    public List<TestRequest> getTestRequestsOfAppointment(int app_id) {
        return testRequestRepository.getTestRequestsOfAppointment(app_id);
    }

    public TestRequest getTestRequestWithRequestId(int request_id) {
        return testRequestRepository.getTestRequestWithRequestId(request_id);
    }

    public List<TestRequest> getTestRequestsOfLaboratorian(int laboratorian_id) {
        return testRequestRepository.getTestRequestsOfLaboratorian(laboratorian_id);
    }

    @Transactional
    public void addTestRequest(int app_id, List<Integer> testTypes) {
        testTypes.forEach(test_type_id -> {
            // Add test request
            testRequestRepository.addTestRequest(LocalDateTime.now(),
                    app_id, test_type_id);

            // Choose random laboratorian
            List<Laboratorian> eligibleLaboratorians = laboratorianRepository.getLaboratoriansForTest(test_type_id);
            Random rand = new Random();
            Laboratorian laboratorian = eligibleLaboratorians.get(rand.nextInt(eligibleLaboratorians.size()));

            // Assign the test request to the laboratorian
            TestRequest testRequest1 = testRequestRepository.getTestRequestWithAppId(app_id, test_type_id);
            processRepository.addProcess(LocalDate.now(), laboratorian.getLaboratorian_id(), testRequest1.getRequest_id());
        });
        appointmentRepository.updateAppointmentToTestRequested(app_id);
    }
}
