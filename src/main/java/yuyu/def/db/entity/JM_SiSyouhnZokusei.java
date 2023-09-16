package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.mapping.GenJM_SiSyouhnZokusei;


/**
 * 支払商品属性マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SiSyouhnZokusei} の JavaDoc を参照してください。<br />
 * @see     GenJM_SiSyouhnZokusei<br />
 * @see     PKJM_SiSyouhnZokusei<br />
 * @see     QJM_SiSyouhnZokusei<br />
 * @see     GenQJM_SiSyouhnZokusei<br />
 */
@Entity
public class JM_SiSyouhnZokusei extends GenJM_SiSyouhnZokusei {

    private static final long serialVersionUID = 1L;

    public JM_SiSyouhnZokusei() {
    }

    public JM_SiSyouhnZokusei(String pSyouhncd,C_KyhgndkataKbn pKyhgndkatakbn,Integer pSyouhnsdno,String pKyuuhucd) {
        super(pSyouhncd,pKyhgndkatakbn,pSyouhnsdno,pKyuuhucd);
    }



    private JM_Kyuuhu jM_Kyuuhu ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JM_SiSyouhnZokusei.KYUUHUCD  , referencedColumnName=JM_Kyuuhu.KYUUHUCD, insertable=false, updatable=false)
    })
    public  JM_Kyuuhu getKyuuhu() {
        return jM_Kyuuhu;
    }

    public void setKyuuhu(JM_Kyuuhu pJM_Kyuuhu) {
        this.jM_Kyuuhu = pJM_Kyuuhu;
    }

}

