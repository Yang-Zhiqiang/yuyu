package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenSV_KiykSyuhnData;

/**
 * 契約商品情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_KiykSyuhnData} の JavaDoc を参照してください。<br />
 * @see     GenSV_KiykSyuhnData<br />
 * @see     PKSV_KiykSyuhnData<br />
 * @see     QSV_KiykSyuhnData<br />
 * @see     GenQSV_KiykSyuhnData<br />
 */
@Entity
public class SV_KiykSyuhnData extends GenSV_KiykSyuhnData {

    private static final long serialVersionUID = 1L;

    public SV_KiykSyuhnData() {
    }

    public SV_KiykSyuhnData(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pHenkousikibetukey) {
        super(pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pHenkousikibetukey);
    }



    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=SV_KiykSyuhnData.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=SV_KiykSyuhnData.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

