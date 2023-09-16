package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.mapping.GenZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouRn;

/**
 * 税適預り金数理連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_ZitkAzukarikinSrRendouRn} の JavaDoc を参照してください。
 * @see     GenZT_ZitkAzukarikinSrRendouRn
 * @see     PKZT_ZitkAzukarikinSrRendouRn
 * @see     QZT_ZitkAzukarikinSrRendouRn
 * @see     GenQZT_ZitkAzukarikinSrRendouRn
 */
@Entity
public class ZT_ZitkAzukarikinSrRendouRn extends GenZT_ZitkAzukarikinSrRendouRn {

    private static final long serialVersionUID = 1L;

    public ZT_ZitkAzukarikinSrRendouRn() {
    }

    public ZT_ZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
