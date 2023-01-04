//@SpringBootTest
public class RepositoryTest {

    //@Autowired
   

//    @Autowired
//    private MecanicoRepository MecanicoRepository;
//
//    @Test
//    public void whenFindByName_thenReturnMecanicos() {
//        Mecanicos alex = new Mecanicos("cc",1030639,"Jhon","Emilio","Levi","Porras","3504126985","Carrera 4","algo@gmail.com","a");
//        entityManager.persistAndFlush(alex);
//
////        Mecanicos found = MecanicoRepository.findByName(alex.getPrimerNombre());
////        assertThat(found.getPrimerNombre()).isEqualTo(alex.getPrimerNombre());
//    }
//
////    @Test
////    public void whenInvalidName_thenReturnNull() {
////        Mecanicos fromDb = MecanicoRepository.findByName("doesNotExist");
////        assertThat(fromDb).isNull();
////    }
//
//    @Test
//    public void whenFindById_thenReturnMecanicos() {
//        Mecanicos emp = new Mecanicos();
//        entityManager.persistAndFlush(emp);
//
//        Mecanicos fromDb = MecanicoRepository.findById(emp.getDocumento()).orElse(null);
//        assertThat(fromDb.getPrimerNombre()).isEqualTo(emp.getPrimerNombre());
//    }
//
//    @Test
//    public void whenInvalidId_thenReturnNull() {
//        Mecanicos fromDb = MecanicoRepository.findById(12).orElse(null);
//        assertThat(fromDb).isNull();
//    }
//
//    @Test
//    public void givenSetOfMecanicoss_whenFindAll_thenReturnAllMecanicoss() {
//        Mecanicos user1 = new Mecanicos("cc",1030630689,"Juan","Camilo","Leal","Rojas","3503476985","Carrera 4","algo@gmail.com","a");
//        Mecanicos user2 = new Mecanicos("cc",1143136415,"Jhon","Sebastian","Laguna","Rios","3123132589","Carrera 4","cosa@gmail.com","a");
//        Mecanicos user3 = new Mecanicos("cc",801032,"Carlos",null,"Centeno","Torres","3208562147","Carrera 4","pruebas@gmail.com","a");
//        
//
//        entityManager.persist(user1);
//        entityManager.persist(user2);
//        entityManager.persist(user3);
//        entityManager.flush();
//
//        List<Mecanicos> allMecanicoss = MecanicoRepository.findAll();
//
//        assertThat(allMecanicoss).hasSize(3).extracting(Mecanicos::getDocumento).containsOnly(user1.getDocumento(), user2.getDocumento(), user3.getDocumento());
//    }

}
