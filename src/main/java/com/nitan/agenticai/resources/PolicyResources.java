package com.nitan.agenticai.resources;

import org.springframework.ai.mcp.annotation.McpResource;
import org.springframework.stereotype.Component;

@Component
class PolicyResources {

  @McpResource(
      uri = "policy://vacation",
      name = "vacation-policy",
      description = "Vacation policy for Romania employees: entitlement, carry-over, requests.",
      mimeType = "text/plain")
  public String vacationPolicy() {
    return """
        This policy is applicable to all Romania employees. It also applies to romanian \
        employees who are assigned and working on projects abroad.

        You are entitled to take 21 working days of vacation, per calendar year, as \
        specified in your employment contract.

        In addition to the regular vacation, you can also benefit from extra vacation days. \
        For more information, please refer to the Benefit Online platform.

        Disclaimer: some exceptions may be made in the case of mergers, acquisitions and \
        people transfers.

        You must take the vacation within the calendar year in which it was accrued. Any \
        unused vacation can be carried over from one calendar year into the following year \
        for a maximum of 18 months. In case the remaining vacation days are not redeemed at \
        the end of the 18 months period, they will be cancelled.

        The compensation in money for the leave not taken shall only be allowed at the end \
        of the individual employment contract.

        You must request the vacation directly on MyVacation tool, all approvals are \
        managed directly through the form.

        For questions related to this supplement please reach out to Human Resources \
        through Ask HR.
        """;
  }

  @McpResource(
          uri = "policy://referral",
          name = "referral-policy",
          description = "Referral policy for Romania employees: entitlement, carry-over, requests.",
          mimeType = "text/plain")
  public String referralPolicy() {
    return """
            Submitting a referral is simple. Just follow these steps and let us do the rest!
            1.Find an opportunity by browsing the available jobs in Workday.
            2.Talk to your friends and find the right match.
            3.Upload your friend’s resume in Workday.
            4.Ask your friend to confirm the referral by accessing the link received by email.
            5.Claim your bonus and receive:
              -Global Operations and Corporate Functions: 3,600 lei gross for each successful hire at levels 12–9, or 6,000 lei gross for hires at level 8 and above.
              -Technology: 6000 lei gross for each successful hire at levels 12-9, 12000 lei gross for or each successful hire at levels 8-7
              -Industry X: 6000 lei gross for each successful hire at levels 12-9, 12000 lei gross for each successful hire at levels 8-7
            """;
  }
}