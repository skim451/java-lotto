import model.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto(46, 6);
    }

    @Test
    public void generateTest() {
        assertThat(lotto.getNumbers().size())
                .isEqualTo((int) (lotto.getNumbers().stream().distinct().count()));
    }

    @Test
    public void compareTest() {
        Lotto lotto1 = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 7, 8));

        Lotto winningNumber = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto1.compare(winningNumber)).isEqualTo(6);
        assertThat(lotto2.compare(winningNumber)).isEqualTo(5);
        assertThat(lotto3.compare(winningNumber)).isEqualTo(4);

    }
}
