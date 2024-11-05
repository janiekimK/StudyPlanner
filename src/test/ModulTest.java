 private Modul mockedModule

 @BeforeEach
void setUp() {
        mockedModul = Mockito.spy(new Modul("Testmodul", 5));
        }