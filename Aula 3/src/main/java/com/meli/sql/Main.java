package com.meli.sql;

import com.meli.sql.dto.DentistDiaryDTO;
import com.meli.sql.entity.*;
import com.meli.sql.entity.enums.*;
import com.meli.sql.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlConfig");
        EntityManager em = factory.createEntityManager();

        DentistRepository dentistRepository = new DentistRepository(em);
        DiaryRepository diaryRepository = new DiaryRepository(em);
        PatientRepository patientRepository = new PatientRepository(em);
        TurnRepository turnRepository = new TurnRepository(em);
        TurnStatusRepository turnStatusRepository = new TurnStatusRepository(em);
        UserRepository userRepository = new UserRepository(em);

        em.getTransaction().begin();

        User user = new User("igcruz", "123123", UserStatusEnum.ATIVO);
        userRepository.save(user);

        Patient p1 = new Patient("Igor", "Cruz", "Rua Cruzeiro", "525.602.780-81", LocalDate.parse("1998-12-21"), "(95) 2728-9223", "igor@email.com");
        Patient p2 = new Patient("Jorge", "Souza", "Rua Brasil", "872.653.860-19", LocalDate.parse("1992-02-10"), "(95) 98342-8816", "jorge@email.com");
        Collection<Patient> patients = Arrays.asList(p1, p2);
        patientRepository.saveAll(patients);

        Dentist d1 = new Dentist("Lucas", "Silva", "Rua Canada", "858.648.085-12", LocalDate.parse("2003-06-04"), "(27) 2619-9742", "lucas@email.com", "123456");
        Dentist d2 = new Dentist("Manuel", "Fernandes", "Rua Bolivia", "936.299.797-50", LocalDate.parse("2001-04-24"), "(27) 98532-0748", "manuel@email.com", "456789");
        Collection<Dentist> dentists = Arrays.asList(d1, d2);
        dentistRepository.saveAll(dentists);

        Diary di1 = new Diary(LocalTime.of(12, 0), LocalTime.of(18, 30), d1);
        Diary di2 = new Diary(LocalTime.of(6,0), LocalTime.of(12, 0), d2);
        Collection<Diary> diaries = Arrays.asList(di1, di2);
        diaryRepository.saveAll(diaries);

        TurnStatus ts1 = new TurnStatus(TurnStatusEnum.CONCLUIDO, "turno concluido");
        TurnStatus ts2 = new TurnStatus(TurnStatusEnum.PENDENTE, "turno pendente");
        TurnStatus ts3 = new TurnStatus(TurnStatusEnum.REMARCADO, "turno remarcado");
        TurnStatus ts4 = new TurnStatus(TurnStatusEnum.CANCELADO, "turno cancelado");
        Collection<TurnStatus> turnStatuses = Arrays.asList(ts1, ts2, ts3, ts4);
        turnStatusRepository.saveAll(turnStatuses);

        Turn t1 = new Turn(1, di1, ts1, p1);
        Turn t2 = new Turn(1, di2, ts1, p2);
        Turn t3 = new Turn(2, di1, ts2, p1);
        Turn t4 = new Turn(2, di2, ts3, p2);
        Turn t5 = new Turn(1, di2, ts2, p2);
        Turn t6 = new Turn(1, di2, ts2, p2);
        Turn t7 = new Turn(1, di1, ts4, p2);
        Turn t8 = new Turn(1, di1, ts3, p1);
        Collection<Turn> turns = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8);
        turnRepository.saveAll(turns);

        em.getTransaction().commit();
        em.clear();

        System.out.println("Exercicio 1 - Pacientes tratados em um dia:");

        List<Patient> firstDayPatients = patientRepository.getAllPatientsTreated(1);
        firstDayPatients.forEach(p -> System.out.println(p.toString()));

        System.out.println();

        System.out.println("Exercicio 2 - Medicos que possuam mais de 1 turno em um dia:");

        List<Dentist> dentistsWithMoreTurns = dentistRepository.getDentistWithMoreThan2TurnAtDay(1);
        dentistsWithMoreTurns.forEach(d -> System.out.println(d.toString()));

        System.out.println();

        System.out.println("Exercicio 3 - Todos os turnos finalizados:");

        List<Turn> closedTurns = turnRepository.getAllClosedTurns();
        closedTurns.forEach(t -> System.out.println(t.toString()));

        System.out.println();

        System.out.println("Exercicio 4 - Todos os turnos pendentes em um dia:");

        List<Turn> pendingTurns = turnRepository.getPendingTurnsAtDay(1);
        pendingTurns.forEach(t -> System.out.println(t.toString()));

        System.out.println();

        System.out.println("Exercicio 5 - Listar agenda de um dentista:");

        List<DentistDiaryDTO> dentistDiaries = dentistRepository.getDentistDiary(1);
        dentistDiaries.forEach(d -> System.out.println(d.toString()));

        System.out.println();

        System.out.println("Exercicio 6 - Listar os turnos que foram remarcados de um dentista:");

        List<Turn> dentistRescheduledTurns = turnRepository.getRescheduledTurnsByDentist(2);
        dentistRescheduledTurns.forEach(t -> System.out.println(t.toString()));

        System.out.println();

        System.out.println("Exercicio 7 - Listar todos dos turnos remarcados:");

        List<Turn> allRescheduledTurns = turnRepository.getAllRescheduledTurns();
        allRescheduledTurns.forEach(t -> System.out.println(t.toString()));

        System.out.println();
    }
}
