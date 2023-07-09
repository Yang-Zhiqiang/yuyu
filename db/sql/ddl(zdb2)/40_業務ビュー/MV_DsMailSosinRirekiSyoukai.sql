CREATE VIEW MV_DsMailSosinRirekiSyoukai AS SELECT 
       a1.dsdatasakuseiymd                          /* ＤＳデータ作成日 */
     , a1.dskokno                                   /* ＤＳ顧客番号 */
     , a1.dsmailhaisinrenban                        /* ＤＳメール配信連番 */
     , a1.syono                                     /* 証券番号 */
     , a1.dssousinmailsyubetukbn                    /* ＤＳ送信メール種別区分 */
     , a1.haisinjidsmailaddress                     /* 配信時ＤＳメールアドレス */
     , a1.dssousinno                                /* ＤＳ送信番号 */
     , a2.haisinerrorcount                          /* 配信エラーカウント */
     , a1.kousinsyaId                               /* 更新者ＩＤ */
     , a1.kousinTime                                /* 更新時間 */
     , a1.kousinKinou                               /* 更新機能 */
     , a1.version                                   /* バージョン */
FROM MT_DsMailHaisinRireki_Z a1 
LEFT OUTER JOIN (
    SELECT b1.dssousinno                            /* ＤＳ送信番号 */
         , b1.haisinerrorcount                      /* 配信エラーカウント */
    FROM MT_DsHaisinErrorList_Z b1
    UNION ALL
    SELECT c1.dssousinno                            /* ＤＳ送信番号 */
         , c1.haisinerrorcount                      /* 配信エラーカウント */
    FROM MT_DsHaisinErrorList2_Z c1
) a2 
ON a1.dssousinno = a2.dssousinno
;