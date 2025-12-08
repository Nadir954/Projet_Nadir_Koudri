package fr.nadir.koudri.ProxiBanque.web.controller;

import fr.nadir.koudri.ProxiBanque.domain.agency.Agency;
import fr.nadir.koudri.ProxiBanque.service.AgencyService;
import fr.nadir.koudri.ProxiBanque.service.AuditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditService auditService;
    private final AgencyService agencyService;

    public AuditController(AuditService auditService, AgencyService agencyService) {
        this.auditService = auditService;
        this.agencyService = agencyService;
    }

    @GetMapping("/{agencyId}")
    public boolean audit(@PathVariable Long agencyId) {
        Agency agency = agencyService.findById(agencyId);
        if (agency == null) return false;

        return auditService.isAgencyCompliant(agency);
    }
}
