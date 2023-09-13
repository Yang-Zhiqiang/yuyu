package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）保全契約詳細取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetHozenKeiyakuSyousaiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetHozenKeiyakuSyousaiOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    private String iwsSyouhnnm;

    public String getIwsSyouhnnm() {
        return iwsSyouhnnm;
    }

    public void setIwsSyouhnnm(String pIwsSyouhnnm) {
        iwsSyouhnnm = pIwsSyouhnnm;
    }

    private String iwsHhknnmkn;

    public String getIwsHhknnmkn() {
        return iwsHhknnmkn;
    }

    public void setIwsHhknnmkn(String pIwsHhknnmkn) {
        iwsHhknnmkn = pIwsHhknnmkn;
    }

    private String iwsHhknseiymdstr;

    public String getIwsHhknseiymdstr() {
        return iwsHhknseiymdstr;
    }

    public void setIwsHhknseiymdstr(String pIwsHhknseiymdstr) {
        iwsHhknseiymdstr = pIwsHhknseiymdstr;
    }

    private String iwsKykymdstr;

    public String getIwsKykymdstr() {
        return iwsKykymdstr;
    }

    public void setIwsKykymdstr(String pIwsKykymdstr) {
        iwsKykymdstr = pIwsKykymdstr;
    }

    private String iwsTutakinumukbn;

    public String getIwsTutakinumukbn() {
        return iwsTutakinumukbn;
    }

    public void setIwsTutakinumukbn(String pIwsTutakinumukbn) {
        iwsTutakinumukbn = pIwsTutakinumukbn;
    }

    private String iwsSbhsyumukbn;

    public String getIwsSbhsyumukbn() {
        return iwsSbhsyumukbn;
    }

    public void setIwsSbhsyumukbn(String pIwsSbhsyumukbn) {
        iwsSbhsyumukbn = pIwsSbhsyumukbn;
    }

    private String iwsKghsyumukbn;

    public String getIwsKghsyumukbn() {
        return iwsKghsyumukbn;
    }

    public void setIwsKghsyumukbn(String pIwsKghsyumukbn) {
        iwsKghsyumukbn = pIwsKghsyumukbn;
    }

    private String iwsIryhsyumukbn;

    public String getIwsIryhsyumukbn() {
        return iwsIryhsyumukbn;
    }

    public void setIwsIryhsyumukbn(String pIwsIryhsyumukbn) {
        iwsIryhsyumukbn = pIwsIryhsyumukbn;
    }

    private String iwsRougohsyumukbn;

    public String getIwsRougohsyumukbn() {
        return iwsRougohsyumukbn;
    }

    public void setIwsRougohsyumukbn(String pIwsRougohsyumukbn) {
        iwsRougohsyumukbn = pIwsRougohsyumukbn;
    }

    private String iwsSakuseikijyunymdstr;

    public String getIwsSakuseikijyunymdstr() {
        return iwsSakuseikijyunymdstr;
    }

    public void setIwsSakuseikijyunymdstr(String pIwsSakuseikijyunymdstr) {
        iwsSakuseikijyunymdstr = pIwsSakuseikijyunymdstr;
    }

    private String iwsSksikijyunymdkawaserate;

    public String getIwsSksikijyunymdkawaserate() {
        return iwsSksikijyunymdkawaserate;
    }

    public void setIwsSksikijyunymdkawaserate(String pIwsSksikijyunymdkawaserate) {
        iwsSksikijyunymdkawaserate = pIwsSksikijyunymdkawaserate;
    }

    private String iwsKwsratekijyunymdsakusei;

    public String getIwsKwsratekijyunymdsakusei() {
        return iwsKwsratekijyunymdsakusei;
    }

    public void setIwsKwsratekijyunymdsakusei(String pIwsKwsratekijyunymdsakusei) {
        iwsKwsratekijyunymdsakusei = pIwsKwsratekijyunymdsakusei;
    }

    private String iwsPtumitatekngkyen;

    public String getIwsPtumitatekngkyen() {
        return iwsPtumitatekngkyen;
    }

    public void setIwsPtumitatekngkyen(String pIwsPtumitatekngkyen) {
        iwsPtumitatekngkyen = pIwsPtumitatekngkyen;
    }

    private String iwsPtumitatekngkgaika;

    public String getIwsPtumitatekngkgaika() {
        return iwsPtumitatekngkgaika;
    }

    public void setIwsPtumitatekngkgaika(String pIwsPtumitatekngkgaika) {
        iwsPtumitatekngkgaika = pIwsPtumitatekngkgaika;
    }

    private String iwsKyktuukasyu;

    public String getIwsKyktuukasyu() {
        return iwsKyktuukasyu;
    }

    public void setIwsKyktuukasyu(String pIwsKyktuukasyu) {
        iwsKyktuukasyu = pIwsKyktuukasyu;
    }

    private String iwsRsytuukasyu;

    public String getIwsRsytuukasyu() {
        return iwsRsytuukasyu;
    }

    public void setIwsRsytuukasyu(String pIwsRsytuukasyu) {
        iwsRsytuukasyu = pIwsRsytuukasyu;
    }

    private String iwsKaiyakuhryen;

    public String getIwsKaiyakuhryen() {
        return iwsKaiyakuhryen;
    }

    public void setIwsKaiyakuhryen(String pIwsKaiyakuhryen) {
        iwsKaiyakuhryen = pIwsKaiyakuhryen;
    }

    private String iwsKaiyakuhrgaika;

    public String getIwsKaiyakuhrgaika() {
        return iwsKaiyakuhrgaika;
    }

    public void setIwsKaiyakuhrgaika(String pIwsKaiyakuhrgaika) {
        iwsKaiyakuhrgaika = pIwsKaiyakuhrgaika;
    }

    private String iwsKaiyakuhrsuiiumukbn;

    public String getIwsKaiyakuhrsuiiumukbn() {
        return iwsKaiyakuhrsuiiumukbn;
    }

    public void setIwsKaiyakuhrsuiiumukbn(String pIwsKaiyakuhrsuiiumukbn) {
        iwsKaiyakuhrsuiiumukbn = pIwsKaiyakuhrsuiiumukbn;
    }

    private String iwsAisyoumei;

    public String getIwsAisyoumei() {
        return iwsAisyoumei;
    }

    public void setIwsAisyoumei(String pIwsAisyoumei) {
        iwsAisyoumei = pIwsAisyoumei;
    }

    private String iwsKyknmkn;

    public String getIwsKyknmkn() {
        return iwsKyknmkn;
    }

    public void setIwsKyknmkn(String pIwsKyknmkn) {
        iwsKyknmkn = pIwsKyknmkn;
    }

    private String iwsKyknmkj;

    public String getIwsKyknmkj() {
        return iwsKyknmkj;
    }

    public void setIwsKyknmkj(String pIwsKyknmkj) {
        iwsKyknmkj = pIwsKyknmkj;
    }

    private String iwsKykseiymdstr;

    public String getIwsKykseiymdstr() {
        return iwsKykseiymdstr;
    }

    public void setIwsKykseiymdstr(String pIwsKykseiymdstr) {
        iwsKykseiymdstr = pIwsKykseiymdstr;
    }

    private String iwsKyksei;

    public String getIwsKyksei() {
        return iwsKyksei;
    }

    public void setIwsKyksei(String pIwsKyksei) {
        iwsKyksei = pIwsKyksei;
    }

    private String iwsSbuktnin;

    public String getIwsSbuktnin() {
        return iwsSbuktnin;
    }

    public void setIwsSbuktnin(String pIwsSbuktnin) {
        iwsSbuktnin = pIwsSbuktnin;
    }

    private String iwsUktmidasikbn1;

    public String getIwsUktmidasikbn1() {
        return iwsUktmidasikbn1;
    }

    public void setIwsUktmidasikbn1(String pIwsUktmidasikbn1) {
        iwsUktmidasikbn1 = pIwsUktmidasikbn1;
    }

    private String iwsUktkbn1str;

    public String getIwsUktkbn1str() {
        return iwsUktkbn1str;
    }

    public void setIwsUktkbn1str(String pIwsUktkbn1str) {
        iwsUktkbn1str = pIwsUktkbn1str;
    }

    private String iwsUktsimei1;

    public String getIwsUktsimei1() {
        return iwsUktsimei1;
    }

    public void setIwsUktsimei1(String pIwsUktsimei1) {
        iwsUktsimei1 = pIwsUktsimei1;
    }

    private String iwsUktmidasikbn2;

    public String getIwsUktmidasikbn2() {
        return iwsUktmidasikbn2;
    }

    public void setIwsUktmidasikbn2(String pIwsUktmidasikbn2) {
        iwsUktmidasikbn2 = pIwsUktmidasikbn2;
    }

    private String iwsUktkbn2str;

    public String getIwsUktkbn2str() {
        return iwsUktkbn2str;
    }

    public void setIwsUktkbn2str(String pIwsUktkbn2str) {
        iwsUktkbn2str = pIwsUktkbn2str;
    }

    private String iwsUktsimei2;

    public String getIwsUktsimei2() {
        return iwsUktsimei2;
    }

    public void setIwsUktsimei2(String pIwsUktsimei2) {
        iwsUktsimei2 = pIwsUktsimei2;
    }

    private String iwsUktmidasikbn3;

    public String getIwsUktmidasikbn3() {
        return iwsUktmidasikbn3;
    }

    public void setIwsUktmidasikbn3(String pIwsUktmidasikbn3) {
        iwsUktmidasikbn3 = pIwsUktmidasikbn3;
    }

    private String iwsUktkbn3str;

    public String getIwsUktkbn3str() {
        return iwsUktkbn3str;
    }

    public void setIwsUktkbn3str(String pIwsUktkbn3str) {
        iwsUktkbn3str = pIwsUktkbn3str;
    }

    private String iwsUktsimei3;

    public String getIwsUktsimei3() {
        return iwsUktsimei3;
    }

    public void setIwsUktsimei3(String pIwsUktsimei3) {
        iwsUktsimei3 = pIwsUktsimei3;
    }

    private String iwsUktmidasikbn4;

    public String getIwsUktmidasikbn4() {
        return iwsUktmidasikbn4;
    }

    public void setIwsUktmidasikbn4(String pIwsUktmidasikbn4) {
        iwsUktmidasikbn4 = pIwsUktmidasikbn4;
    }

    private String iwsUktkbn4str;

    public String getIwsUktkbn4str() {
        return iwsUktkbn4str;
    }

    public void setIwsUktkbn4str(String pIwsUktkbn4str) {
        iwsUktkbn4str = pIwsUktkbn4str;
    }

    private String iwsUktsimei4;

    public String getIwsUktsimei4() {
        return iwsUktsimei4;
    }

    public void setIwsUktsimei4(String pIwsUktsimei4) {
        iwsUktsimei4 = pIwsUktsimei4;
    }

    private String iwsUktmidasikbn5;

    public String getIwsUktmidasikbn5() {
        return iwsUktmidasikbn5;
    }

    public void setIwsUktmidasikbn5(String pIwsUktmidasikbn5) {
        iwsUktmidasikbn5 = pIwsUktmidasikbn5;
    }

    private String iwsUktkbn5str;

    public String getIwsUktkbn5str() {
        return iwsUktkbn5str;
    }

    public void setIwsUktkbn5str(String pIwsUktkbn5str) {
        iwsUktkbn5str = pIwsUktkbn5str;
    }

    private String iwsUktsimei5;

    public String getIwsUktsimei5() {
        return iwsUktsimei5;
    }

    public void setIwsUktsimei5(String pIwsUktsimei5) {
        iwsUktsimei5 = pIwsUktsimei5;
    }

    private String iwsUktmidasikbn6;

    public String getIwsUktmidasikbn6() {
        return iwsUktmidasikbn6;
    }

    public void setIwsUktmidasikbn6(String pIwsUktmidasikbn6) {
        iwsUktmidasikbn6 = pIwsUktmidasikbn6;
    }

    private String iwsUktkbn6str;

    public String getIwsUktkbn6str() {
        return iwsUktkbn6str;
    }

    public void setIwsUktkbn6str(String pIwsUktkbn6str) {
        iwsUktkbn6str = pIwsUktkbn6str;
    }

    private String iwsUktsimei6;

    public String getIwsUktsimei6() {
        return iwsUktsimei6;
    }

    public void setIwsUktsimei6(String pIwsUktsimei6) {
        iwsUktsimei6 = pIwsUktsimei6;
    }

    private String iwsUktmidasikbn7;

    public String getIwsUktmidasikbn7() {
        return iwsUktmidasikbn7;
    }

    public void setIwsUktmidasikbn7(String pIwsUktmidasikbn7) {
        iwsUktmidasikbn7 = pIwsUktmidasikbn7;
    }

    private String iwsUktkbn7str;

    public String getIwsUktkbn7str() {
        return iwsUktkbn7str;
    }

    public void setIwsUktkbn7str(String pIwsUktkbn7str) {
        iwsUktkbn7str = pIwsUktkbn7str;
    }

    private String iwsUktsimei7;

    public String getIwsUktsimei7() {
        return iwsUktsimei7;
    }

    public void setIwsUktsimei7(String pIwsUktsimei7) {
        iwsUktsimei7 = pIwsUktsimei7;
    }

    private String iwsUktmidasikbn8;

    public String getIwsUktmidasikbn8() {
        return iwsUktmidasikbn8;
    }

    public void setIwsUktmidasikbn8(String pIwsUktmidasikbn8) {
        iwsUktmidasikbn8 = pIwsUktmidasikbn8;
    }

    private String iwsUktkbn8str;

    public String getIwsUktkbn8str() {
        return iwsUktkbn8str;
    }

    public void setIwsUktkbn8str(String pIwsUktkbn8str) {
        iwsUktkbn8str = pIwsUktkbn8str;
    }

    private String iwsUktsimei8;

    public String getIwsUktsimei8() {
        return iwsUktsimei8;
    }

    public void setIwsUktsimei8(String pIwsUktsimei8) {
        iwsUktsimei8 = pIwsUktsimei8;
    }

    private String iwsUktmidasikbn9;

    public String getIwsUktmidasikbn9() {
        return iwsUktmidasikbn9;
    }

    public void setIwsUktmidasikbn9(String pIwsUktmidasikbn9) {
        iwsUktmidasikbn9 = pIwsUktmidasikbn9;
    }

    private String iwsUktkbn9str;

    public String getIwsUktkbn9str() {
        return iwsUktkbn9str;
    }

    public void setIwsUktkbn9str(String pIwsUktkbn9str) {
        iwsUktkbn9str = pIwsUktkbn9str;
    }

    private String iwsUktsimei9;

    public String getIwsUktsimei9() {
        return iwsUktsimei9;
    }

    public void setIwsUktsimei9(String pIwsUktsimei9) {
        iwsUktsimei9 = pIwsUktsimei9;
    }

    private String iwsUktmidasikbn10;

    public String getIwsUktmidasikbn10() {
        return iwsUktmidasikbn10;
    }

    public void setIwsUktmidasikbn10(String pIwsUktmidasikbn10) {
        iwsUktmidasikbn10 = pIwsUktmidasikbn10;
    }

    private String iwsUktkbn10str;

    public String getIwsUktkbn10str() {
        return iwsUktkbn10str;
    }

    public void setIwsUktkbn10str(String pIwsUktkbn10str) {
        iwsUktkbn10str = pIwsUktkbn10str;
    }

    private String iwsUktsimei10;

    public String getIwsUktsimei10() {
        return iwsUktsimei10;
    }

    public void setIwsUktsimei10(String pIwsUktsimei10) {
        iwsUktsimei10 = pIwsUktsimei10;
    }

    private String iwsTrkkzknmkn1;

    public String getIwsTrkkzknmkn1() {
        return iwsTrkkzknmkn1;
    }

    public void setIwsTrkkzknmkn1(String pIwsTrkkzknmkn1) {
        iwsTrkkzknmkn1 = pIwsTrkkzknmkn1;
    }

    private String iwsTrkkzknmkn2;

    public String getIwsTrkkzknmkn2() {
        return iwsTrkkzknmkn2;
    }

    public void setIwsTrkkzknmkn2(String pIwsTrkkzknmkn2) {
        iwsTrkkzknmkn2 = pIwsTrkkzknmkn2;
    }

    private String iwsHknkknkaisiymd1str;

    public String getIwsHknkknkaisiymd1str() {
        return iwsHknkknkaisiymd1str;
    }

    public void setIwsHknkknkaisiymd1str(String pIwsHknkknkaisiymd1str) {
        iwsHknkknkaisiymd1str = pIwsHknkknkaisiymd1str;
    }

    private String iwsHknkknmanryouymd1str;

    public String getIwsHknkknmanryouymd1str() {
        return iwsHknkknmanryouymd1str;
    }

    public void setIwsHknkknmanryouymd1str(String pIwsHknkknmanryouymd1str) {
        iwsHknkknmanryouymd1str = pIwsHknkknmanryouymd1str;
    }

    @MaxLength(max=2)
    @SingleByteStrings
    private String iwsHknkkn1;

    public String getIwsHknkkn1() {
        return iwsHknkkn1;
    }

    public void setIwsHknkkn1(String pIwsHknkkn1) {
        iwsHknkkn1 = pIwsHknkkn1;
    }

    private String iwsHknkknkaisiymd2str;

    public String getIwsHknkknkaisiymd2str() {
        return iwsHknkknkaisiymd2str;
    }

    public void setIwsHknkknkaisiymd2str(String pIwsHknkknkaisiymd2str) {
        iwsHknkknkaisiymd2str = pIwsHknkknkaisiymd2str;
    }

    private String iwsHknkknmanryouymd2str;

    public String getIwsHknkknmanryouymd2str() {
        return iwsHknkknmanryouymd2str;
    }

    public void setIwsHknkknmanryouymd2str(String pIwsHknkknmanryouymd2str) {
        iwsHknkknmanryouymd2str = pIwsHknkknmanryouymd2str;
    }

    private String iwsHknkkn2;

    public String getIwsHknkkn2() {
        return iwsHknkkn2;
    }

    public void setIwsHknkkn2(String pIwsHknkkn2) {
        iwsHknkkn2 = pIwsHknkkn2;
    }

    private String iwsHknkknkaisiymd3str;

    public String getIwsHknkknkaisiymd3str() {
        return iwsHknkknkaisiymd3str;
    }

    public void setIwsHknkknkaisiymd3str(String pIwsHknkknkaisiymd3str) {
        iwsHknkknkaisiymd3str = pIwsHknkknkaisiymd3str;
    }

    private String iwsHknkknmanryouymd3str;

    public String getIwsHknkknmanryouymd3str() {
        return iwsHknkknmanryouymd3str;
    }

    public void setIwsHknkknmanryouymd3str(String pIwsHknkknmanryouymd3str) {
        iwsHknkknmanryouymd3str = pIwsHknkknmanryouymd3str;
    }

    private String iwsKykdrtkhkumu;

    public String getIwsKykdrtkhkumu() {
        return iwsKykdrtkhkumu;
    }

    public void setIwsKykdrtkhkumu(String pIwsKykdrtkhkumu) {
        iwsKykdrtkhkumu = pIwsKykdrtkhkumu;
    }

    private String iwsStdrsktkyhkumu;

    public String getIwsStdrsktkyhkumu() {
        return iwsStdrsktkyhkumu;
    }

    public void setIwsStdrsktkyhkumu(String pIwsStdrsktkyhkumu) {
        iwsStdrsktkyhkumu = pIwsStdrsktkyhkumu;
    }

    private String iwsYennykntkhkumu;

    public String getIwsYennykntkhkumu() {
        return iwsYennykntkhkumu;
    }

    public void setIwsYennykntkhkumu(String pIwsYennykntkhkumu) {
        iwsYennykntkhkumu = pIwsYennykntkhkumu;
    }

    private String iwsGaikanykntkhkumu;

    public String getIwsGaikanykntkhkumu() {
        return iwsGaikanykntkhkumu;
    }

    public void setIwsGaikanykntkhkumu(String pIwsGaikanykntkhkumu) {
        iwsGaikanykntkhkumu = pIwsGaikanykntkhkumu;
    }

    private String iwsTargettkhkumu;

    public String getIwsTargettkhkumu() {
        return iwsTargettkhkumu;
    }

    public void setIwsTargettkhkumu(String pIwsTargettkhkumu) {
        iwsTargettkhkumu = pIwsTargettkhkumu;
    }

    private String iwsSyksbyensitihsyutyhkumu;

    public String getIwsSyksbyensitihsyutyhkumu() {
        return iwsSyksbyensitihsyutyhkumu;
    }

    public void setIwsSyksbyensitihsyutyhkumu(String pIwsSyksbyensitihsyutyhkumu) {
        iwsSyksbyensitihsyutyhkumu = pIwsSyksbyensitihsyutyhkumu;
    }

    private String iwsJyudkaigomehrtkhkumu;

    public String getIwsJyudkaigomehrtkhkumu() {
        return iwsJyudkaigomehrtkhkumu;
    }

    public void setIwsJyudkaigomehrtkhkumu(String pIwsJyudkaigomehrtkhkumu) {
        iwsJyudkaigomehrtkhkumu = pIwsJyudkaigomehrtkhkumu;
    }

    private String iwsZeiseitkkktkykhukaumu;

    public String getIwsZeiseitkkktkykhukaumu() {
        return iwsZeiseitkkktkykhukaumu;
    }

    public void setIwsZeiseitkkktkykhukaumu(String pIwsZeiseitkkktkykhukaumu) {
        iwsZeiseitkkktkykhukaumu = pIwsZeiseitkkktkykhukaumu;
    }

    private String iwsRsymdkawaserate;

    public String getIwsRsymdkawaserate() {
        return iwsRsymdkawaserate;
    }

    public void setIwsRsymdkawaserate(String pIwsRsymdkawaserate) {
        iwsRsymdkawaserate = pIwsRsymdkawaserate;
    }

    private String iwsRsymdkawaseratestigi;

    public String getIwsRsymdkawaseratestigi() {
        return iwsRsymdkawaseratestigi;
    }

    public void setIwsRsymdkawaseratestigi(String pIwsRsymdkawaseratestigi) {
        iwsRsymdkawaseratestigi = pIwsRsymdkawaseratestigi;
    }

    private String iwsKwsratekijyunymdrs;

    public String getIwsKwsratekijyunymdrs() {
        return iwsKwsratekijyunymdrs;
    }

    public void setIwsKwsratekijyunymdrs(String pIwsKwsratekijyunymdrs) {
        iwsKwsratekijyunymdrs = pIwsKwsratekijyunymdrs;
    }

    private String iwsKwsratekijyunymdrsstigi;

    public String getIwsKwsratekijyunymdrsstigi() {
        return iwsKwsratekijyunymdrsstigi;
    }

    public void setIwsKwsratekijyunymdrsstigi(String pIwsKwsratekijyunymdrsstigi) {
        iwsKwsratekijyunymdrsstigi = pIwsKwsratekijyunymdrsstigi;
    }

    private String iwsRsgakuyen;

    public String getIwsRsgakuyen() {
        return iwsRsgakuyen;
    }

    public void setIwsRsgakuyen(String pIwsRsgakuyen) {
        iwsRsgakuyen = pIwsRsgakuyen;
    }

    private String iwsRsgakustigi;

    public String getIwsRsgakustigi() {
        return iwsRsgakustigi;
    }

    public void setIwsRsgakustigi(String pIwsRsgakustigi) {
        iwsRsgakustigi = pIwsRsgakustigi;
    }

    private String iwsKijyunkingaku;

    public String getIwsKijyunkingaku() {
        return iwsKijyunkingaku;
    }

    public void setIwsKijyunkingaku(String pIwsKijyunkingaku) {
        iwsKijyunkingaku = pIwsKijyunkingaku;
    }

    private String iwsItijibrprsyen;

    public String getIwsItijibrprsyen() {
        return iwsItijibrprsyen;
    }

    public void setIwsItijibrprsyen(String pIwsItijibrprsyen) {
        iwsItijibrprsyen = pIwsItijibrprsyen;
    }

    private String iwsItijibrpgaika;

    public String getIwsItijibrpgaika() {
        return iwsItijibrpgaika;
    }

    public void setIwsItijibrpgaika(String pIwsItijibrpgaika) {
        iwsItijibrpgaika = pIwsItijibrpgaika;
    }

    private String iwsItijibrprsgaika;

    public String getIwsItijibrprsgaika() {
        return iwsItijibrprsgaika;
    }

    public void setIwsItijibrprsgaika(String pIwsItijibrprsgaika) {
        iwsItijibrprsgaika = pIwsItijibrprsgaika;
    }

    private String iwsKihonhokenkngkgaika;

    public String getIwsKihonhokenkngkgaika() {
        return iwsKihonhokenkngkgaika;
    }

    public void setIwsKihonhokenkngkgaika(String pIwsKihonhokenkngkgaika) {
        iwsKihonhokenkngkgaika = pIwsKihonhokenkngkgaika;
    }

    private String iwsMkhgkwari;

    public String getIwsMkhgkwari() {
        return iwsMkhgkwari;
    }

    public void setIwsMkhgkwari(String pIwsMkhgkwari) {
        iwsMkhgkwari = pIwsMkhgkwari;
    }

    private String iwsSibohknkngkyen;

    public String getIwsSibohknkngkyen() {
        return iwsSibohknkngkyen;
    }

    public void setIwsSibohknkngkyen(String pIwsSibohknkngkyen) {
        iwsSibohknkngkyen = pIwsSibohknkngkyen;
    }

    private String iwsSibohknkngkgaika;

    public String getIwsSibohknkngkgaika() {
        return iwsSibohknkngkgaika;
    }

    public void setIwsSibohknkngkgaika(String pIwsSibohknkngkgaika) {
        iwsSibohknkngkgaika = pIwsSibohknkngkgaika;
    }

    private String iwsSgsbhknkngkyen;

    public String getIwsSgsbhknkngkyen() {
        return iwsSgsbhknkngkyen;
    }

    public void setIwsSgsbhknkngkyen(String pIwsSgsbhknkngkyen) {
        iwsSgsbhknkngkyen = pIwsSgsbhknkngkyen;
    }

    private String iwsSgsbhknkngkkgaika;

    public String getIwsSgsbhknkngkkgaika() {
        return iwsSgsbhknkngkkgaika;
    }

    public void setIwsSgsbhknkngkkgaika(String pIwsSgsbhknkngkkgaika) {
        iwsSgsbhknkngkkgaika = pIwsSgsbhknkngkkgaika;
    }

    private String iwsSgsbhknkngkhyoujiumu;

    public String getIwsSgsbhknkngkhyoujiumu() {
        return iwsSgsbhknkngkhyoujiumu;
    }

    public void setIwsSgsbhknkngkhyoujiumu(String pIwsSgsbhknkngkhyoujiumu) {
        iwsSgsbhknkngkhyoujiumu = pIwsSgsbhknkngkhyoujiumu;
    }

    private String iwsKjsmsaihakkoukahikbn;

    public String getIwsKjsmsaihakkoukahikbn() {
        return iwsKjsmsaihakkoukahikbn;
    }

    public void setIwsKjsmsaihakkoukahikbn(String pIwsKjsmsaihakkoukahikbn) {
        iwsKjsmsaihakkoukahikbn = pIwsKjsmsaihakkoukahikbn;
    }

    private String iwsKykmeigihnkkahikbn;

    public String getIwsKykmeigihnkkahikbn() {
        return iwsKykmeigihnkkahikbn;
    }

    public void setIwsKykmeigihnkkahikbn(String pIwsKykmeigihnkkahikbn) {
        iwsKykmeigihnkkahikbn = pIwsKykmeigihnkkahikbn;
    }

    private String iwsSyoukensaihkkahikbn;

    public String getIwsSyoukensaihkkahikbn() {
        return iwsSyoukensaihkkahikbn;
    }

    public void setIwsSyoukensaihkkahikbn(String pIwsSyoukensaihkkahikbn) {
        iwsSyoukensaihkkahikbn = pIwsSyoukensaihkkahikbn;
    }

    private String iwsStdrsktkytthkkahikbn;

    public String getIwsStdrsktkytthkkahikbn() {
        return iwsStdrsktkytthkkahikbn;
    }

    public void setIwsStdrsktkytthkkahikbn(String pIwsStdrsktkytthkkahikbn) {
        iwsStdrsktkytthkkahikbn = pIwsStdrsktkytthkkahikbn;
    }

    private String iwsTargettkhkkahikbn;

    public String getIwsTargettkhkkahikbn() {
        return iwsTargettkhkkahikbn;
    }

    public void setIwsTargettkhkkahikbn(String pIwsTargettkhkkahikbn) {
        iwsTargettkhkkahikbn = pIwsTargettkhkkahikbn;
    }

    private String iwsHokenkngkksnkekkakbn;

    public String getIwsHokenkngkksnkekkakbn() {
        return iwsHokenkngkksnkekkakbn;
    }

    public void setIwsHokenkngkksnkekkakbn(String pIwsHokenkngkksnkekkakbn) {
        iwsHokenkngkksnkekkakbn = pIwsHokenkngkksnkekkakbn;
    }

    private String iwsKykniyusyoukaikahikbn;

    public String getIwsKykniyusyoukaikahikbn() {
        return iwsKykniyusyoukaikahikbn;
    }

    public void setIwsKykniyusyoukaikahikbn(String pIwsKykniyusyoukaikahikbn) {
        iwsKykniyusyoukaikahikbn = pIwsKykniyusyoukaikahikbn;
    }

    private String iwsTumitatekinitenkahikbn;

    public String getIwsTumitatekinitenkahikbn() {
        return iwsTumitatekinitenkahikbn;
    }

    public void setIwsTumitatekinitenkahikbn(String pIwsTumitatekinitenkahikbn) {
        iwsTumitatekinitenkahikbn = pIwsTumitatekinitenkahikbn;
    }

    private String iwsDskaiyakukahikbn;

    public String getIwsDskaiyakukahikbn() {
        return iwsDskaiyakukahikbn;
    }

    public void setIwsDskaiyakukahikbn(String pIwsDskaiyakukahikbn) {
        iwsDskaiyakukahikbn = pIwsDskaiyakukahikbn;
    }

    private String iwsAdrhenkoukahikbn;

    public String getIwsAdrhenkoukahikbn() {
        return iwsAdrhenkoukahikbn;
    }

    public void setIwsAdrhenkoukahikbn(String pIwsAdrhenkoukahikbn) {
        iwsAdrhenkoukahikbn = pIwsAdrhenkoukahikbn;
    }

    private String iwsPhrkhouhenkoukahikbn;

    public String getIwsPhrkhouhenkoukahikbn() {
        return iwsPhrkhouhenkoukahikbn;
    }

    public void setIwsPhrkhouhenkoukahikbn(String pIwsPhrkhouhenkoukahikbn) {
        iwsPhrkhouhenkoukahikbn = pIwsPhrkhouhenkoukahikbn;
    }

    private String iwsHknkkn3hyoujiumu;

    public String getIwsHknkkn3hyoujiumu() {
        return iwsHknkkn3hyoujiumu;
    }

    public void setIwsHknkkn3hyoujiumu(String pIwsHknkkn3hyoujiumu) {
        iwsHknkkn3hyoujiumu = pIwsHknkkn3hyoujiumu;
    }

    private String iwsYakkanbunsyono;

    public String getIwsYakkanbunsyono() {
        return iwsYakkanbunsyono;
    }

    public void setIwsYakkanbunsyono(String pIwsYakkanbunsyono) {
        iwsYakkanbunsyono = pIwsYakkanbunsyono;
    }

    private String iwsYoteiriritu;

    public String getIwsYoteiriritu() {
        return iwsYoteiriritu;
    }

    public void setIwsYoteiriritu(String pIwsYoteiriritu) {
        iwsYoteiriritu = pIwsYoteiriritu;
    }

    private String iwsTumitateriritustr;

    public String getIwsTumitateriritustr() {
        return iwsTumitateriritustr;
    }

    public void setIwsTumitateriritustr(String pIwsTumitateriritustr) {
        iwsTumitateriritustr = pIwsTumitateriritustr;
    }

    private String iwsLoadinghnkgtmttrrt;

    public String getIwsLoadinghnkgtmttrrt() {
        return iwsLoadinghnkgtmttrrt;
    }

    public void setIwsLoadinghnkgtmttrrt(String pIwsLoadinghnkgtmttrrt) {
        iwsLoadinghnkgtmttrrt = pIwsLoadinghnkgtmttrrt;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
