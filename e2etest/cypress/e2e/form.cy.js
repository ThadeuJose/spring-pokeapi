describe('Form', () => {
  it('Should show new pokemon', () => {
    let pokemon = "Xerneas";

    cy.visit('/');
    cy.get('[data-cy="input"]').type(`${pokemon}{enter}`);
    cy.url().should('include', '/pokemon');
    cy.get('[data-cy="name"]').should('have.text',pokemon);
  })
})