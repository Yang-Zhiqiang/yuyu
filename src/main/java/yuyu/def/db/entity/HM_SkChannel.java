package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.mapping.GenHM_SkChannel;


/**
 * 新契約チャネルマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkChannel} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkChannel<br />
 * @see     PKHM_SkChannel<br />
 * @see     QHM_SkChannel<br />
 * @see     GenQHM_SkChannel<br />
 */
@Entity
public class HM_SkChannel extends GenHM_SkChannel {

    private static final long serialVersionUID = 1L;

    public HM_SkChannel() {
    }

    public HM_SkChannel(C_Channelcd pChannelcd,String pOyadrtencd) {
        super(pChannelcd,pOyadrtencd);
    }



    private BM_Tyouhyourenrakusaki bM_Tyouhyourenrakusaki ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HM_SkChannel.TYHYRENRAKUSIKIBETUKBN  , referencedColumnName=BM_Tyouhyourenrakusaki.TYHYRENRAKUSIKIBETUKBN, insertable=false, updatable=false)
    })
    public  BM_Tyouhyourenrakusaki getTyouhyourenrakusaki() {
        return bM_Tyouhyourenrakusaki;
    }

    public void setTyouhyourenrakusaki(BM_Tyouhyourenrakusaki pBM_Tyouhyourenrakusaki) {
        this.bM_Tyouhyourenrakusaki = pBM_Tyouhyourenrakusaki;
    }

}

