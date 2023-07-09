CREATE VIEW MV_DsMailSosinRirekiSyoukai AS SELECT 
       a1.dsdatasakuseiymd                          /* �c�r�f�[�^�쐬�� */
     , a1.dskokno                                   /* �c�r�ڋq�ԍ� */
     , a1.dsmailhaisinrenban                        /* �c�r���[���z�M�A�� */
     , a1.syono                                     /* �،��ԍ� */
     , a1.dssousinmailsyubetukbn                    /* �c�r���M���[����ʋ敪 */
     , a1.haisinjidsmailaddress                     /* �z�M���c�r���[���A�h���X */
     , a1.dssousinno                                /* �c�r���M�ԍ� */
     , a2.haisinerrorcount                          /* �z�M�G���[�J�E���g */
     , a1.kousinsyaId                               /* �X�V�҂h�c */
     , a1.kousinTime                                /* �X�V���� */
     , a1.kousinKinou                               /* �X�V�@�\ */
     , a1.version                                   /* �o�[�W���� */
FROM MT_DsMailHaisinRireki_Z a1 
LEFT OUTER JOIN (
    SELECT b1.dssousinno                            /* �c�r���M�ԍ� */
         , b1.haisinerrorcount                      /* �z�M�G���[�J�E���g */
    FROM MT_DsHaisinErrorList_Z b1
    UNION ALL
    SELECT c1.dssousinno                            /* �c�r���M�ԍ� */
         , c1.haisinerrorcount                      /* �z�M�G���[�J�E���g */
    FROM MT_DsHaisinErrorList2_Z c1
) a2 
ON a1.dssousinno = a2.dssousinno
;