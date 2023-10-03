package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Ｄ支払統計中継用一時保存データBeanクラス<br/>
 */
@AllArgsConstructor
public class StDshrTukiTyukeiyouItzHznBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String ztydshrym;

    @Getter @Setter
    private String ztykeiyakunendo;

    @Getter @Setter
    private String ztyannaikigetu;

    @Getter @Setter
    private String ztyhknsyruikbn;

    @Getter @Setter
    private String ztysegcd;

    @Getter @Setter
    private String ztyshrriyuukbn;

    @Getter @Setter
    private String ztyannaikbn;

    @Getter @Setter
    private String ztyduketorihouhoukbn;

    @Getter @Setter
    private String ztysyoumetukbn;

    @Getter @Setter
    private String ztybikinhyj;

    @Getter @Setter
    private String ztyskskbn;

    @Getter @Setter
    private Long ztysrkensuu;

    @Getter @Setter
    private Long ztysrhsys;

    @Getter @Setter
    private Long ztytoujigyounendod;

    @Getter @Setter
    private Long ztytoujigyounendohasseidrsk;

    @Getter @Setter
    private Long ztyzenjigyounendomatudzndk;

    @Getter @Setter
    private Long ztyyokujigyounendod;

    @Getter @Setter
    private Long ztyhushrtoujigyounendod;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}