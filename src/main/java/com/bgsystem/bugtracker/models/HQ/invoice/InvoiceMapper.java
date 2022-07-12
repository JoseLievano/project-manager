package com.bgsystem.bugtracker.models.HQ.invoice;

import com.bgsystem.bugtracker.models.HQ.client.ClientMapper;
import com.bgsystem.bugtracker.models.HQ.plan.PlanMapper;
import com.bgsystem.bugtracker.models.client.business.BusinessMapper;
import com.bgsystem.bugtracker.shared.mapper.DefaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMapper implements DefaultMapper <InvoiceDTO, InvoiceMiniDTO, InvoiceForm, InvoiceEntity>{

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public InvoiceDTO toDTO(InvoiceEntity entity) {

        if (entity == null)
            return null;

        return InvoiceDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .dateGenerated(entity.getDateGenerated())
                .limitDate(entity.getLimitDate())
                .isPaid(entity.getIsPaid())
                .overDue(entity.getOverDue())
                .number(entity.getNumber())
                .plan(planMapper.toSmallDTO(entity.getPlanEntity()))
                .client(clientMapper.toSmallDTO(entity.getClientEntity()))
                .business(businessMapper.toSmallDTO(entity.getBusinessEntity()))
                .build();
    }

    @Override
    public InvoiceMiniDTO toSmallDTO(InvoiceEntity entity) {

        if (entity == null)
            return null;

        return InvoiceMiniDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .dateGenerated(entity.getDateGenerated())
                .limitDate(entity.getLimitDate())
                .isPaid(entity.getIsPaid())
                .overDue(entity.getOverDue())
                .number(entity.getNumber())
                .build();
    }

    @Override
    public InvoiceEntity toEntity(InvoiceForm form) {

        if (form == null)
            return null;

        return InvoiceEntity.builder()
                .id(form.getId())
                .amount(form.getAmount())
                .dateGenerated(form.getDateGenerated())
                .limitDate(form.getLimitDate())
                .isPaid(form.getIsPaid())
                .number(form.getNumber())
                .build();
    }
}
