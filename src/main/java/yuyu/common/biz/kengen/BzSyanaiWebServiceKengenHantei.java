package yuyu.common.biz.kengen;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_KengenHntiKbn;
import yuyu.def.db.entity.AM_IdCard;

/**
 * 業務共通 権限 社内Webサービス_権限判定
 */
public class BzSyanaiWebServiceKengenHantei {

    private static final String KINOUID_KYKNAIYOUSYOUKAI =
        "yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebService/exec";

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private static Logger logger;

    public C_KengenHntiKbn exec(String pOperatorId, String pOrgCode, String pKinouid) {

        logger.debug("▽ 社内Webサービス_権限判定 開始");

        C_KengenHntiKbn kengenHanteiCheckkekka = null;

        if (KINOUID_KYKNAIYOUSYOUKAI.equals(pKinouid)) {

            String orgCodeTop3 = pOrgCode.substring(0, 3);

            YuyuBizConfig bizConf = YuyuBizConfig.getInstance();

            if (((orgCodeTop3.compareTo("300") >= 0 && !bizConf.getSisyaAtukaiSosikiCdList().contains(orgCodeTop3)) ||
                bizConf.getSisyaReigaiSosikiCdList().contains(orgCodeTop3)) ||
                ((orgCodeTop3.compareTo("300") < 0 ||
                    bizConf.getSisyaAtukaiSosikiCdList().contains(orgCodeTop3)) && pOrgCode.charAt(3) != '0' &&
                    !bizConf.getSisyaReigaiSosikiCdList().contains(orgCodeTop3))) {
            }
            else {
                logger.debug("△ 社内Webサービス_権限判定 終了");

                return C_KengenHntiKbn.TANMATUERROR;
            }

            String operatorIdTop2= pOperatorId.substring(0, 2);
            String operatorId3To8 = pOperatorId.substring(2, 8);

            AM_IdCard idCardEntity = baseDomManager.getIdCard(operatorIdTop2, operatorId3To8);

            if (idCardEntity != null) {

                String syozokusosikicdTop3 = idCardEntity.getSyozokusosikicd().substring(0, 3);

                if ((syozokusosikicdTop3.compareTo("300") >= 0 &&
                    !bizConf.getSisyaAtukaiSosikiCdList().contains(syozokusosikicdTop3)) ||
                    bizConf.getSisyaReigaiSosikiCdList().contains(syozokusosikicdTop3)) {

                    if ("01".equals(operatorIdTop2) ||
                        "02".equals(operatorIdTop2) ||
                        "03".equals(operatorIdTop2) ||
                        "07".equals(operatorIdTop2) ||
                        "08".equals(operatorIdTop2) ||
                        "10".equals(operatorIdTop2) ||
                        "11".equals(operatorIdTop2) ||
                        "21".equals(operatorIdTop2) ||
                        "22".equals(operatorIdTop2) ||
                        "23".equals(operatorIdTop2) ||
                        "30".equals(operatorIdTop2) ||
                        "31".equals(operatorIdTop2) ||
                        "32".equals(operatorIdTop2) ||
                        "35".equals(operatorIdTop2) ||
                        "44".equals(operatorIdTop2) ||
                        "46".equals(operatorIdTop2) ||
                        "48".equals(operatorIdTop2) ||
                        "49".equals(operatorIdTop2) ||
                        "51".equals(operatorIdTop2) ||
                        "56".equals(operatorIdTop2) ||
                        "57".equals(operatorIdTop2)) {

                        kengenHanteiCheckkekka = C_KengenHntiKbn.OK;
                    }
                    else {
                        kengenHanteiCheckkekka = C_KengenHntiKbn.SIYOSYAERROR;
                    }

                }
                else if ((syozokusosikicdTop3.compareTo("300") < 0 ||
                    bizConf.getSisyaAtukaiSosikiCdList().contains(syozokusosikicdTop3)) &&
                    idCardEntity.getSyozokusosikicd().charAt(3) == '0' &&
                    !bizConf.getSisyaReigaiSosikiCdList().contains(syozokusosikicdTop3)) {

                    if ("01".equals(operatorIdTop2) &&
                        ("1".equals(idCardEntity.getTanmatusiyoukbn()) || "2".equals(idCardEntity.getTanmatusiyoukbn()))) {

                        kengenHanteiCheckkekka = C_KengenHntiKbn.OK;
                    }
                    else if ("03".equals(operatorIdTop2) && "1".equals(idCardEntity.getTanmatusiyoukbn())) {

                        kengenHanteiCheckkekka = C_KengenHntiKbn.OK;
                    }
                    else {
                        kengenHanteiCheckkekka = C_KengenHntiKbn.SIYOSYAERROR;
                    }

                }
                else {
                    kengenHanteiCheckkekka = C_KengenHntiKbn.SIYOSYAERROR;
                }

            }
            else {
                kengenHanteiCheckkekka = C_KengenHntiKbn.SIYOSYAERROR;
            }
        }

        logger.debug("△ 社内Webサービス_権限判定 終了");

        return kengenHanteiCheckkekka;
    }
}
